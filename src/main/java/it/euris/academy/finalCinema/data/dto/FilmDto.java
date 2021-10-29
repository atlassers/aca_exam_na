package it.euris.academy.finalCinema.data.dto;

import it.euris.academy.finalCinema.data.Genere;
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
  private String prezzo;

  @Override
  public Film toModel() {
    return Film.builder()
        .idFilm(idFilm == null ? null : Long.valueOf(idFilm))
        .autore(autore)
        .produttore(produttore)
        .genere(Genere.valueOf(genere))
        .etaMinima(Integer.valueOf(etaMinima))
        .durata(Integer.valueOf(durata))
        .prezzo(Long.valueOf(prezzo))
        .build();
  }
}
