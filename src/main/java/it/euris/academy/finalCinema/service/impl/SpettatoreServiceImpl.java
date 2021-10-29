package it.euris.academy.finalCinema.service.impl;

import it.euris.academy.finalCinema.data.dto.SpettatoreDto;
import it.euris.academy.finalCinema.data.model.Spettatore;
import it.euris.academy.finalCinema.exception.IdMustBeNullException;
import it.euris.academy.finalCinema.exception.IdMustNotBeNullException;
import it.euris.academy.finalCinema.repository.SpettatoreRepository;
import it.euris.academy.finalCinema.service.SpettatoreService;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpettatoreServiceImpl implements SpettatoreService {

  @Autowired
  SpettatoreRepository spettatoreRepository;

  @Override
  public List<SpettatoreDto> getAll() {
    return spettatoreRepository.findAll()
        .stream().map(spettatore -> spettatore.toDto())
        .collect(Collectors.toList());
  }

  @Override
  public SpettatoreDto get(Long id) {
    Optional<Spettatore> findById = spettatoreRepository.findById(id);
    if(findById.isPresent()) {
      return findById.get().toDto();
    }
    return null;
  }

  @Override
  public SpettatoreDto add(SpettatoreDto spettatoreDto) {
    if(spettatoreDto.getIdSpettatore() != null) {
      throw new IdMustBeNullException();
    }
    return spettatoreRepository.save(spettatoreDto.toModel()).toDto();
  }

  @Override
  public SpettatoreDto update(SpettatoreDto spettatoreDto) {
    if(spettatoreDto.getIdSpettatore().isEmpty()) {
      throw new IdMustNotBeNullException();
    }
    return spettatoreRepository.save(spettatoreDto.toModel()).toDto();
  }

  @Override
  public Boolean delete(Long id) {
    spettatoreRepository.deleteById(id);
    Optional<Spettatore> deletedSpettatore = spettatoreRepository.findById(id);
    if(deletedSpettatore.isEmpty()) {
      return Boolean.TRUE;
    } else {
      return Boolean.FALSE;
    }
  }
}
