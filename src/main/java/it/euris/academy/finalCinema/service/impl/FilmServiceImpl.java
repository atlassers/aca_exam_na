package it.euris.academy.finalCinema.service.impl;

import it.euris.academy.finalCinema.data.dto.FilmDto;
import it.euris.academy.finalCinema.repository.FilmRepository;
import it.euris.academy.finalCinema.service.FilmService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FilmServiceImpl implements FilmService {

  @Autowired
  FilmRepository filmRepository;

  @Override
  public List<FilmDto> getAll() {
    return null;
  }

  @Override
  public FilmDto get(Long id) {
    return null;
  }

  @Override
  public FilmDto add(FilmDto filmDto) {
    return null;
  }

  @Override
  public FilmDto update(FilmDto movieDto) {
    return null;
  }

  @Override
  public Boolean delete(Long id) {
    return null;
  }
}
