package it.euris.academy.finalCinema.exception;

public class SalaAlCompleto extends RuntimeException{

  public SalaAlCompleto() {
    super("La sala è piena :(");
  }
}
