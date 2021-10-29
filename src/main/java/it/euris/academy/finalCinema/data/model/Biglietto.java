package it.euris.academy.finalCinema.data.model;

import it.euris.academy.finalCinema.data.archetype.Dto;
import it.euris.academy.finalCinema.data.archetype.Model;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "biglietto")
@Entity
public class Biglietto implements Model {

  @Id
  @Column(name = "id_biglietto")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long idBiglietto;

  @ManyToOne(cascade = CascadeType.REFRESH)
  @JoinColumn(name = "sala")
  private SalaCinematografica sala;

  @Column(name = "posto_a_sedere")
  private String postoASedere;

  @Column(name = "data_emissione")
  private Date dataEmissione;

  @OneToOne(cascade = CascadeType.REFRESH)
  @JoinColumn(name = "spettatore")
  private Spettatore spettatore;

  @Override
  public Dto toDto() {
    return null;
  }
}
