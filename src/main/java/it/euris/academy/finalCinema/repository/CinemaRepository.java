package it.euris.academy.finalCinema.repository;

import it.euris.academy.finalCinema.data.model.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CinemaRepository extends JpaRepository<Cinema,Long> {

}
