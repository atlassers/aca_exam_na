package it.euris.academy.finalCinema.data.dto;

import it.euris.academy.finalCinema.data.archetype.Dto;
import it.euris.academy.finalCinema.data.model.Biglietto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class BigliettoDto implements Dto {

  private String idBigliettoDto;
  private String idSala;
  private String postoASedere;
  private String dataEmissione;
  private String idSpettatore;
  private String prezzo;

  @Override
  public Biglietto toModel() {
    return null;
  }
}
