package it.euris.academy.finalCinema.data.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class BigliettoDto {

  private String idSpettatoreDto;
  private String nomeDto;
  private String cognomeDto;
  private String dataNascitaDto;

}
