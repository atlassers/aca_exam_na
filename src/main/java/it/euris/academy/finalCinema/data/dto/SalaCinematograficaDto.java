package it.euris.academy.finalCinema.data.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import it.euris.academy.finalCinema.data.archetype.Dto;
import it.euris.academy.finalCinema.data.model.Cinema;
import it.euris.academy.finalCinema.data.model.Film;
import it.euris.academy.finalCinema.data.model.SalaCinematografica;
import it.euris.academy.finalCinema.repository.CinemaRepository;
import it.euris.academy.finalCinema.repository.FilmRepository;
import it.euris.academy.finalCinema.service.CinemaService;
import it.euris.academy.finalCinema.service.FilmService;
import it.euris.academy.finalCinema.service.impl.CinemaServiceImpl;
import it.euris.academy.finalCinema.service.impl.FilmServiceImpl;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class SalaCinematograficaDto implements Dto {

  private String idSala;
  private String postiTotali;
  private String postiOccupati;
  private String cinemaId;
  private String filmId;

  @Override
  public SalaCinematografica toModel() {
    return SalaCinematografica.builder()
        .idSala(idSala == null ? null : Long.valueOf(idSala))
        .postiTotali(Integer.valueOf(postiTotali))
        .postiOccupati(Integer.valueOf(postiOccupati))
        //.cinema(new Cinema())
        //.film(new Film())
        //.cinema(cinemaService.getModel(Long.valueOf(cinemaId)))
        //.film(filmService.getModel(Long.valueOf(filmId)))
        .build();
  }
}
