package it.euris.academy.finalCinema.data.dto;

import it.euris.academy.finalCinema.data.archetype.Dto;
import it.euris.academy.finalCinema.data.model.Spettatore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class SpettatoreDto implements Dto {

  private String idSpettatore;
  private String nome;
  private String cognome;
  private String dataNascita;

  @Override
  public Spettatore toModel() {
    return null;
  }
}
