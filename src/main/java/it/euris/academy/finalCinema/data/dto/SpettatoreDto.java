package it.euris.academy.finalCinema.data.dto;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class SpettatoreDto {

  private String idSpettatore;
  private String nome;
  private String cognome;
  private String dataNascita;

}
