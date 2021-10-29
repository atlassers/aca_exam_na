package it.euris.academy.finalCinema.data.model;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "spettatore")
@Entity
public class Spettatore {

  @Id
  @Column(name = "id_spettatore")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long idSpettatore;

  @Column(name = "nome")
  private String nome;

  @Column(name = "cognome")
  private String cognome;

  @Column(name = "data_nascita")
  private Date dataNascita;

  @OneToOne(mappedBy = "spettatore", cascade = CascadeType.REFRESH)
  private Biglietto biglietto;
}
