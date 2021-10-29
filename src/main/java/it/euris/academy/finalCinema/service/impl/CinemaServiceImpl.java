package it.euris.academy.finalCinema.service.impl;

import it.euris.academy.finalCinema.data.dto.CinemaDto;
import it.euris.academy.finalCinema.repository.CinemaRepository;
import it.euris.academy.finalCinema.service.CinemaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CinemaServiceImpl implements CinemaService {

  @Autowired
  CinemaRepository cinemaRepository;

  @Override
  public List<CinemaDto> getAll() {
    return null;
  }

  @Override
  public CinemaDto get(Long id) {
    return null;
  }

  @Override
  public CinemaDto add(CinemaDto cinemaDto) {
    return null;
  }

  @Override
  public CinemaDto update(CinemaDto cinemaDto) {
    return null;
  }

  @Override
  public Boolean delete(Long id) {
    return null;
  }
}
