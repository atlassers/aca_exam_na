package it.euris.academy.finalCinema.data.model;

import it.euris.academy.finalCinema.data.Genere;
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
public class Film {

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

  // OneToMany con SalaCinematografica
  @OneToMany(mappedBy = "film", cascade = CascadeType.REFRESH)
  @Builder.Default
  private List<SalaCinematografica> sale = new ArrayList<>();
}
