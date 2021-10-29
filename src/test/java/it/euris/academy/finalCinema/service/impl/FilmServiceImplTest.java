package it.euris.academy.finalCinema.service.impl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;

import it.euris.academy.finalCinema.data.dto.FilmDto;
import it.euris.academy.finalCinema.data.model.Film;
import it.euris.academy.finalCinema.repository.FilmRepository;
import java.util.ArrayList;
import java.util.Optional;
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

  ////      delete()          ////////////////////////////////////////////////////
  @Test
  @DisplayName("GIVEN id present into database WHEN delete() method invoked THEN delete method should be invoked and return TRUE")
  public void givenExistingIdWhenDeleteThenDeleteIsPerformedAndReturnsTrue() {
    // arrange
    Long id = 1L;
    Mockito.when(mockedFilmRepository.findById(id)).thenReturn(Optional.empty());

    // act & assert
    assertEquals(Boolean.TRUE, systemUnderTest.delete(id));
    Mockito.verify(mockedFilmRepository, times(1)).deleteById(any());;
  }

  @Test
  @DisplayName("GIVEN id present into database WHEN delete() method invoked THEN return FALSE")
  public void givenNotExistingIdWhenDeleteThenDeleteIsPerformedAndReturnsFalse() {
    // arrange
    Long id = 1L;
    Film film = new Film(1L, null, null, null, null, null, null,null);
    Mockito.when(mockedFilmRepository.findById(id)).thenReturn(Optional.of(film));

    // act & assert
    assertEquals(Boolean.FALSE, systemUnderTest.delete(id));
  }

}