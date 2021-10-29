package it.euris.academy.finalCinema.repository;

import it.euris.academy.finalCinema.data.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmRepository extends JpaRepository<Film,Long> {

}
