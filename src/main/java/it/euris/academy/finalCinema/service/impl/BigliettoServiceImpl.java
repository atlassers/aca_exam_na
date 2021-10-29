package it.euris.academy.finalCinema.service.impl;

import it.euris.academy.finalCinema.data.dto.BigliettoDto;
import it.euris.academy.finalCinema.data.model.Biglietto;
import it.euris.academy.finalCinema.exception.IdMustBeNullException;
import it.euris.academy.finalCinema.exception.IdMustNotBeNullException;
import it.euris.academy.finalCinema.repository.BigliettoRepository;
import it.euris.academy.finalCinema.service.BigliettoService;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BigliettoServiceImpl implements BigliettoService {

  @Autowired
  BigliettoRepository bigliettoRepository;

  @Override
  public List<BigliettoDto> getAll() {
    return bigliettoRepository.findAll()
        .stream().map(biglietto -> biglietto.toDto())
        .collect(Collectors.toList());
  }

  @Override
  public BigliettoDto get(Long id) {
    Optional<Biglietto> findById = bigliettoRepository.findById(id);
    if(findById.isPresent()) {
      return findById.get().toDto();
    }
    return null;
  }

  @Override
  public BigliettoDto add(BigliettoDto bigliettoDto) {
    if(bigliettoDto.getIdBigliettoDto() != null) {
      throw new IdMustBeNullException();
    }
    return bigliettoRepository.save(bigliettoDto.toModel()).toDto();
  }

  @Override
  public BigliettoDto update(BigliettoDto bigliettoDto) {
    if(bigliettoDto.getIdBigliettoDto().isEmpty()) {
      throw new IdMustNotBeNullException();
    }
    return bigliettoRepository.save(bigliettoDto.toModel()).toDto();
  }

  @Override
  public Boolean delete(Long id) {
    bigliettoRepository.deleteById(id);
    Optional<Biglietto> deletedBiglietto = bigliettoRepository.findById(id);
    if(deletedBiglietto.isEmpty()) {
      return Boolean.TRUE;
    } else {
      return Boolean.FALSE;
    }
  }
}
