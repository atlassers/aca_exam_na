package it.euris.academy.finalCinema.repository;

import it.euris.academy.finalCinema.data.model.SalaCinematografica;
import it.euris.academy.finalCinema.repository.projection.IMovieViews;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SalaCinematograficaRepository extends JpaRepository<SalaCinematografica,Long> {

  ///  incassi singola sala    /////////////////////////////////////////////////////////////////////
  @Query
      (value = "SELECT SUM(prezzo) FROM academy_cinema_final.sala_cinematografica sala\n"
          + "JOIN academy_cinema_final.biglietto b ON b.sala = sala.id_sala\n"
            + "WHERE id_sala = :idRoom", nativeQuery = true)
  Integer getTotalEarningsOfGivenRoom(@Param("idRoom") Long idRoom);

  ///  film più visto       ////////////////////////////////////////////////////////////////////////
  @Query
      (value = "SELECT MAX(COUNT(f.id_film)) AS totBiglietti, f.id_film AS nomeFilm FROM academy_cinema_final.biglietto b\n"
          + "JOIN academy_cinema_final.sala_cinematografica sala ON b.sala = sala.id_sala\n"
            + "JOIN academy_cinema_final.film f ON sala.film = f.id_film\n"
              + "GROUP BY(f.id_film)", nativeQuery = true)
  IMovieViews getMostViewedMovie();

  ///  film meno visto      ////////////////////////////////////////////////////////////////////////
  @Query
      (value = "SELECT MIN(COUNT(f.id_film)) AS totBiglietti, f.id_film AS nomeFilm FROM academy_cinema_final.biglietto b\n"
          + "JOIN academy_cinema_final.sala_cinematografica sala ON b.sala = sala.id_sala\n"
            + "JOIN academy_cinema_final.film f ON sala.film = f.id_film\n"
              + "GROUP BY(f.id_film)", nativeQuery = true)
  IMovieViews getLeastViewedMovie(@Param("idRoom") Long idRoom);
}
