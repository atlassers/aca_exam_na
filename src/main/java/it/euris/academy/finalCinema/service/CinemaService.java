package it.euris.academy.finalCinema.service;

import it.euris.academy.finalCinema.data.dto.CinemaDto;
import java.util.List;

public interface CinemaService {

  List<CinemaDto> getAll();
  CinemaDto get(Long id);
  CinemaDto add(CinemaDto cinemaDto);
  CinemaDto update(CinemaDto cinemaDto);
  Boolean delete(Long id);
}
