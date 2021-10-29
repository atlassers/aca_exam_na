package it.euris.academy.finalCinema.service;

import it.euris.academy.finalCinema.data.dto.FilmDto;
import java.util.List;

public interface FilmService {

  List<FilmDto> getAll();
  FilmDto get(Long id);
  FilmDto add(FilmDto filmDto);
  FilmDto update(FilmDto movieDto);
  Boolean delete(Long id);
}
