package it.euris.academy.finalCinema.data.dto;

import it.euris.academy.finalCinema.data.archetype.Dto;
import it.euris.academy.finalCinema.data.model.SalaCinematografica;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
