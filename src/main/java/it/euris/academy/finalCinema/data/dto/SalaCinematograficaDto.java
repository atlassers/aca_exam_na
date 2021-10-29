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

  @Override
  public SalaCinematografica toModel() {
    return null;
  }
}
