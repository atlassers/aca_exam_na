package it.euris.academy.finalCinema.data.dto;

import it.euris.academy.finalCinema.data.archetype.Dto;
import it.euris.academy.finalCinema.data.model.Film;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class FilmDto implements Dto {

  private String idFilm;
  private String autore;
  private String produttore;
  private String genere;
  private String etaMinima;
  private String durata;   // in minuti

  @Override
  public Film toModel() {
    return null;
  }
}
