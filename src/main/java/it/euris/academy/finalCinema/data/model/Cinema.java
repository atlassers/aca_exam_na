package it.euris.academy.finalCinema.data.model;

import it.euris.academy.finalCinema.data.archetype.Model;
import it.euris.academy.finalCinema.data.dto.CinemaDto;
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
@Table(name = "cinema")
@Entity
public class Cinema implements Model {

  @Id
  @Column(name = "id_cinema")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long idCinema;

  @OneToMany(mappedBy = "cinema", cascade = CascadeType.REFRESH)
  @Builder.Default
  private List<SalaCinematografica> sale = new ArrayList<>();

  @Override
  public CinemaDto toDto() {
    return CinemaDto.builder()
        .idCinemaDto(String.valueOf(idCinema))
        .build();
  }
}
