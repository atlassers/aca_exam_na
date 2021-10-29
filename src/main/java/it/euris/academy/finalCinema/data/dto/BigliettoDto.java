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
  private String idSpettatoreDto;
  private String nomeDto;
  private String cognomeDto;
  private String dataNascitaDto;

  @Override
  public Biglietto toModel() {
    return null;
  }
}
