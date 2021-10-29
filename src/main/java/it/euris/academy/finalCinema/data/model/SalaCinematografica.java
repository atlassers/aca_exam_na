package it.euris.academy.finalCinema.data.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "sala_cinematografica")
@Entity
public class SalaCinematografica {

  @Id
  @Column(name = "id_sala")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long idSala;

  @Column(name = "posti_totali")
  private Integer postiTotali;

  @ManyToOne(cascade = CascadeType.REFRESH)
  @JoinColumn(name = "cinema")
  private Cinema cinema;

  // ManyToOne con Film
  @ManyToOne(cascade = CascadeType.REFRESH)
  @JoinColumn(name = "film")
  private Film film;

}
