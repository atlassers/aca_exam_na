package it.euris.academy.finalCinema.exception;

public class IdMustBeNullException extends RuntimeException {

  public IdMustBeNullException() {
    super("Id must be null");
  }
}
