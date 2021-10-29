package it.euris.academy.finalCinema.service.impl;

import it.euris.academy.finalCinema.data.dto.BigliettoDto;
import it.euris.academy.finalCinema.data.model.Biglietto;
import it.euris.academy.finalCinema.exception.FilmVietatoAiMinori;
import it.euris.academy.finalCinema.exception.IdMustBeNullException;
import it.euris.academy.finalCinema.exception.IdMustNotBeNullException;
import it.euris.academy.finalCinema.exception.SalaAlCompleto;
import it.euris.academy.finalCinema.repository.BigliettoRepository;
import it.euris.academy.finalCinema.repository.FilmRepository;
import it.euris.academy.finalCinema.repository.SalaCinematograficaRepository;
import it.euris.academy.finalCinema.repository.SpettatoreRepository;
import it.euris.academy.finalCinema.service.BigliettoService;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BigliettoServiceImpl implements BigliettoService {

  @Autowired
  BigliettoRepository bigliettoRepository;

  @Autowired
  SalaCinematograficaRepository salaCinematograficaRepository;

  @Autowired
  FilmRepository filmRepository;

  @Autowired
  SpettatoreRepository spettatoreRepository;

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
    if(salaCinematograficaRepository.getById(Long.valueOf(bigliettoDto.getIdSala())).getPostiOccupati() >=
        salaCinematograficaRepository.getById(Long.valueOf(bigliettoDto.getIdSala())).getPostiTotali()) {
      throw new SalaAlCompleto();
    }

    Calendar calendar = Calendar.getInstance();
    calendar.setTime(Date.from(Instant.now()));
    calendar.add(Calendar.YEAR,-18);

    if(spettatoreRepository.getById(Long.valueOf(bigliettoDto.getIdSpettatore())).getDataNascita().after(calendar.getTime())) {
      throw new FilmVietatoAiMinori();
    }

    Long prezzo = filmRepository.getById(salaCinematograficaRepository.getById(Long.valueOf(bigliettoDto.getIdSala())).getFilm().getIdFilm()).getPrezzo();
    Calendar calendar70 = Calendar.getInstance();
    calendar70.setTime(Date.from(Instant.now()));
    calendar70.add(Calendar.YEAR, -70);

    if(spettatoreRepository.getById(Long.valueOf(bigliettoDto.getIdSpettatore())).getDataNascita().before(calendar.getTime())) {
      bigliettoDto.setPrezzo(String.valueOf(prezzo * 0.90));
    }

    Calendar calendar5 = Calendar.getInstance();
    calendar5.setTime(Date.from(Instant.now()));
    calendar5.add(Calendar.YEAR, -5);

    if(spettatoreRepository.getById(Long.valueOf(bigliettoDto.getIdSpettatore())).getDataNascita().after(calendar.getTime())) {
      bigliettoDto.setPrezzo(String.valueOf(prezzo * 0.50));
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
