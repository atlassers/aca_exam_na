package it.euris.academy.finalCinema.service.impl;

import it.euris.academy.finalCinema.data.dto.SpettatoreDto;
import it.euris.academy.finalCinema.repository.SpettatoreRepository;
import it.euris.academy.finalCinema.service.SpettatoreService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpettatoreServiceImpl implements SpettatoreService {

  @Autowired
  SpettatoreRepository spettatoreRepository;

  @Override
  public List<SpettatoreDto> getAll() {
    return null;
  }

  @Override
  public SpettatoreDto get(Long id) {
    return null;
  }

  @Override
  public SpettatoreDto add(SpettatoreDto spettatoreDto) {
    return null;
  }

  @Override
  public SpettatoreDto update(SpettatoreDto spettatoreDto) {
    return null;
  }

  @Override
  public Boolean delete(Long id) {
    return null;
  }
}
