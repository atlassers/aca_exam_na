package it.euris.academy.finalCinema.service.impl;

import static org.junit.jupiter.api.Assertions.*;

import it.euris.academy.finalCinema.data.dto.FilmDto;
import it.euris.academy.finalCinema.data.model.Film;
import it.euris.academy.finalCinema.repository.FilmRepository;
import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class FilmServiceImplTest {

  @MockBean
  FilmRepository mockedFilmRepository;

  @InjectMocks
  FilmServiceImpl systemUnderTest;

  ///   getAll()   //////////////////////////////////////
  @Test
  @DisplayName("GIVEN empty repository WHEN getAll() method is invoked THEN return empty List")
  void givenEmptyRepoWhenGetAllThenReturnEmptyList() {
    // arrange
    ArrayList<Film> films = new ArrayList<>();
    Mockito.when(mockedFilmRepository.findAll()).thenReturn(films);

    // act & assert
    assertEquals(0, systemUnderTest.getAll().size());
  }

}