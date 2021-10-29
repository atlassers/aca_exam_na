package it.euris.academy.finalCinema.data.model;

import it.euris.academy.finalCinema.data.Genere;
import it.euris.academy.finalCinema.data.archetype.Model;
import it.euris.academy.finalCinema.data.dto.FilmDto;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "film")
@Entity
public class Film implements Model {

  @Id
  @Column(name = "id_film")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long idFilm;

  @Column(name = "autore")
  private String autore;

  @Column(name = "produttore")
  private String produttore;

  @Column(name = "genere")
  private Genere genere;

  @Column(name = "eta_minima")
  private Integer etaMinima;

  @Column(name = "durata")
  private Integer durata;   // in minuti

  @Column(name = "prezzo")
  private Long prezzo;

  @OneToMany(mappedBy = "film", cascade = CascadeType.REFRESH)
  @Builder.Default
  private List<SalaCinematografica> sale = new ArrayList<>();

  @Override
  public FilmDto toDto() {
    return FilmDto.builder()
        .idFilm(String.valueOf(idFilm))
        .autore(autore)
        .produttore(produttore)
        .genere(String.valueOf(genere))
        .etaMinima(String.valueOf(etaMinima))
        .durata(String.valueOf(durata))
        .prezzo(String.valueOf(prezzo))
        .build();
  }
}
