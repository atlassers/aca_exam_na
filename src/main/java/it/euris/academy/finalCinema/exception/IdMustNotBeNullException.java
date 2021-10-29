package it.euris.academy.finalCinema.exception;

public class IdMustNotBeNullException extends RuntimeException{

  public IdMustNotBeNullException() {
    super("Id must not be null");
  }
}
