package it.euris.academy.finalCinema.data.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class SalaCinematograficaDto {

  private String idSala;
  private String postiTotali;

}
