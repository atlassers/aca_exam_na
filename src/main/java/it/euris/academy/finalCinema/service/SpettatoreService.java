package it.euris.academy.finalCinema.service;

import it.euris.academy.finalCinema.data.dto.SpettatoreDto;
import java.util.List;

public interface SpettatoreService {

  List<SpettatoreDto> getAll();
  SpettatoreDto get(Long id);
  SpettatoreDto add(SpettatoreDto spettatoreDto);
  SpettatoreDto update(SpettatoreDto spettatoreDto);
  Boolean delete(Long id);
}
