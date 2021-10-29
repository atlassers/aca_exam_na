package it.euris.academy.finalCinema.service.impl;

import it.euris.academy.finalCinema.data.dto.CinemaDto;
import it.euris.academy.finalCinema.data.model.Cinema;
import it.euris.academy.finalCinema.exception.IdMustBeNullException;
import it.euris.academy.finalCinema.exception.IdMustNotBeNullException;
import it.euris.academy.finalCinema.repository.CinemaRepository;
import it.euris.academy.finalCinema.service.CinemaService;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CinemaServiceImpl implements CinemaService {

  @Autowired
  CinemaRepository cinemaRepository;

  @Override
  public List<CinemaDto> getAll() {
    return cinemaRepository.findAll()
        .stream().map(cinema -> cinema.toDto())
        .collect(Collectors.toList());
  }

  @Override
  public CinemaDto get(Long id) {
    Optional<Cinema> findById = cinemaRepository.findById(id);
    if(findById.isPresent()) {
      return findById.get().toDto();
    }
    return null;
  }

  @Override
  public CinemaDto add(CinemaDto cinemaDto) {
    if(cinemaDto.getIdCinemaDto() != null) {
      throw new IdMustBeNullException();
    }
    return cinemaRepository.save(cinemaDto.toModel()).toDto();
  }

  @Override
  public CinemaDto update(CinemaDto cinemaDto) {
    if(cinemaDto.getIdCinemaDto().isEmpty()) {
      throw new IdMustNotBeNullException();
    }
    return cinemaRepository.save(cinemaDto.toModel()).toDto();
  }

  @Override
  public Boolean delete(Long id) {
    cinemaRepository.deleteById(id);
    Optional<Cinema> deletedCinema = cinemaRepository.findById(id);
    if(deletedCinema.isEmpty()) {
      return Boolean.TRUE;
    } else {
      return Boolean.FALSE;
    }
  }
}
