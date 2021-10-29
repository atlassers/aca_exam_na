package it.euris.academy.finalCinema.exception;

public class FilmVietatoAiMinori extends RuntimeException{

  public FilmVietatoAiMinori() {
    super("Film vietato ai minori :(");
  }
}
