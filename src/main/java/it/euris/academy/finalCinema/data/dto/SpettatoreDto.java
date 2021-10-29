package it.euris.academy.finalCinema.data.dto;

import it.euris.academy.finalCinema.data.archetype.Dto;
import it.euris.academy.finalCinema.data.model.Spettatore;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
    Spettatore s= Spettatore.builder()
        .idSpettatore(Long.valueOf(idSpettatore))
        .nome(nome)
        .cognome(cognome)
        .build();
    try {
      s.setDataNascita(formatter.parse(dataNascita));
    } catch (ParseException e) {
      e.printStackTrace();
    }
    return s;
  }
}
