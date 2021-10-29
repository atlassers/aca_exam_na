package it.euris.academy.finalCinema.service.impl;

import it.euris.academy.finalCinema.data.dto.FilmDto;
import it.euris.academy.finalCinema.data.model.Film;
import it.euris.academy.finalCinema.exception.IdMustBeNullException;
import it.euris.academy.finalCinema.exception.IdMustNotBeNullException;
import it.euris.academy.finalCinema.repository.FilmRepository;
import it.euris.academy.finalCinema.service.FilmService;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FilmServiceImpl implements FilmService {

  @Autowired
  FilmRepository filmRepository;

  @Override
  public List<FilmDto> getAll() {
    return filmRepository.findAll()
        .stream().map(film -> film.toDto())
        .collect(Collectors.toList());
  }

  @Override
  public FilmDto get(Long id) {
    Optional<Film> findById = filmRepository.findById(id);
    if(findById.isPresent()) {
      return findById.get().toDto();
    }
    return null;
  }

  @Override
  public FilmDto add(FilmDto filmDto) {
    if(filmDto.getIdFilm() != null) {
      throw new IdMustBeNullException();
    }
    return filmRepository.save(filmDto.toModel()).toDto();
  }

  @Override
  public FilmDto update(FilmDto filmDto) {
    if(filmDto.getIdFilm().isEmpty()) {
      throw new IdMustNotBeNullException();
    }
    return filmRepository.save(filmDto.toModel()).toDto();
  }

  @Override
  public Boolean delete(Long id) {
    filmRepository.deleteById(id);
    Optional<Film> deletedFilm = filmRepository.findById(id);
    if(deletedFilm.isEmpty()) {
      return Boolean.TRUE;
    } else {
      return Boolean.FALSE;
    }
  }
}
