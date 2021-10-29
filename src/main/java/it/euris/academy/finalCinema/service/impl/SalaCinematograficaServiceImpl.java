package it.euris.academy.finalCinema.service.impl;

import it.euris.academy.finalCinema.data.dto.SalaCinematograficaDto;
import it.euris.academy.finalCinema.data.model.SalaCinematografica;
import it.euris.academy.finalCinema.exception.IdMustBeNullException;
import it.euris.academy.finalCinema.exception.IdMustNotBeNullException;
import it.euris.academy.finalCinema.repository.SalaCinematograficaRepository;
import it.euris.academy.finalCinema.service.SalaCinematograficaService;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalaCinematograficaServiceImpl implements SalaCinematograficaService {

  @Autowired
  SalaCinematograficaRepository salaCinematograficaRepository;

  @Override
  public List<SalaCinematograficaDto> getAll() {
    return salaCinematograficaRepository.findAll()
        .stream().map(salaCinematografica -> salaCinematografica.toDto())
        .collect(Collectors.toList());
  }

  @Override
  public SalaCinematograficaDto get(Long id) {
    Optional<SalaCinematografica> findById = salaCinematograficaRepository.findById(id);
    if(findById.isPresent()) {
      return findById.get().toDto();
    }
    return null;
  }

  @Override
  public SalaCinematograficaDto add(SalaCinematograficaDto salaCinematograficaDto) {
    if(salaCinematograficaDto.getIdSala() != null) {
      throw new IdMustBeNullException();
    }
    return salaCinematograficaRepository.save(salaCinematograficaDto.toModel()).toDto();
  }

  @Override
  public SalaCinematograficaDto update(SalaCinematograficaDto salaCinematograficaDto) {
    if(salaCinematograficaDto.getIdSala().isEmpty()) {
      throw new IdMustNotBeNullException();
    }
    return salaCinematograficaRepository.save(salaCinematograficaDto.toModel()).toDto();
  }

  @Override
  public Boolean delete(Long id) {
    salaCinematograficaRepository.deleteById(id);
    Optional<SalaCinematografica> deletedSala = salaCinematograficaRepository.findById(id);
    if(deletedSala.isEmpty()) {
      return Boolean.TRUE;
    } else {
      return Boolean.FALSE;
    }
  }
}
