package it.euris.academy.finalCinema.data.dto;

import it.euris.academy.finalCinema.data.archetype.Dto;
import it.euris.academy.finalCinema.data.archetype.Model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class BigliettoDto implements Dto {

  private String idSpettatoreDto;
  private String nomeDto;
  private String cognomeDto;
  private String dataNascitaDto;

  @Override
  public Model toModel() {
    return null;
  }
}
