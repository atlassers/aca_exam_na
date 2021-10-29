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

  ///   getAll()             ////////////////////////////////////////////////////
  @Test
  @DisplayName("GIVEN empty repository WHEN getAll() method is invoked THEN return empty List")
  void givenEmptyRepoWhenGetAllThenReturnEmptyList() {
    // arrange
    ArrayList<Film> films = new ArrayList<>();
    Mockito.when(mockedFilmRepository.findAll()).thenReturn(films);

    // act & assert
    assertEquals(0, systemUnderTest.getAll().size());
  }

  @Test
  @DisplayName("GIVEN not empty repository WHEN getAll() method is invoked THEN return List containing what expected")
  void givenNotEmptyRepoWhenGetAllThenReturnEmptyList() {
    // arrange
    ArrayList<Film> films = new ArrayList<>();
    Film mockedFilm1 = new Film(1L, null,null,null,null,null,null,null);
    Film mockedFilm2 = new Film(2L, null,null,null,null,null,null,null);
    films.add(mockedFilm1);
    films.add(mockedFilm2);

    Mockito.when(mockedFilmRepository.findAll()).thenReturn(films);

    // act & assert
    assertEquals(2, systemUnderTest.getAll().size());
    assertEquals("1", systemUnderTest.getAll().get(0).getIdFilm());
    assertEquals("2", systemUnderTest.getAll().get(1).getIdFilm());
  }

  ////      get()             ////////////////////////////////////////////////////
  @Test
  @DisplayName("GIVEN repository not containing Film having given id, WHEN invoking get(id) method THEN should return null")
  public void givenNotPresentFilmWhenUsingGetMethodThenShouldReturnNull() {
    // arrange
    Long id = 1L;
    Mockito.when(mockedFilmRepository.findById(id)).thenReturn(Optional.empty());

    // act & assert
    assertNull(systemUnderTest.get(id));
  }

  @Test
  @DisplayName("GIVEN repository containing Film having given id, WHEN invoking get(id) method THEN should return that Film")
  public void givenPresentFilmWhenUsingGetMethodThenShouldReturnThatExperiment() {
    // arrange
    Long id = 1L;
    Film film = new Film(id, null, null, null, null, null, null,null);
    FilmDto filmDto = new FilmDto("1L", null, null, null, null, null, null);
    Mockito.when(mockedFilmRepository.findById(id)).thenReturn(Optional.of(film));


    // act & assert
    assertNotNull(systemUnderTest.get(id));
    assertEquals("1", systemUnderTest.get(id).getIdFilm());
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