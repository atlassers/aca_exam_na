package it.euris.academy.finalCinema.data.model;

import it.euris.academy.finalCinema.data.archetype.Model;
import it.euris.academy.finalCinema.data.dto.SalaCinematograficaDto;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "sala_cinematografica")
@Entity
public class SalaCinematografica implements Model {

  @Id
  @Column(name = "id_sala")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long idSala;

  @Column(name = "posti_totali")
  private Integer postiTotali;

  @Column(name = "posti_occupati")
  @Builder.Default
  private Integer postiOccupati = 0;

  @ManyToOne(cascade = CascadeType.REFRESH)
  @JoinColumn(name = "cinema")
  private Cinema cinema;

  @ManyToOne(cascade = CascadeType.REFRESH)
  @JoinColumn(name = "film")
  private Film film;

  @OneToMany(mappedBy = "sala", cascade = CascadeType.REFRESH)
  @Builder.Default
  private List<Biglietto> biglietti = new ArrayList<>();

  @Override
  public SalaCinematograficaDto toDto() {
    return null;
  }
}
