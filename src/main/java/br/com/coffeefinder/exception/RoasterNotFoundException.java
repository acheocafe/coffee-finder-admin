package br.com.coffeefinder.exception;

public class RoasterNotFoundException extends RuntimeException {

  public RoasterNotFoundException(String id) {
    super("Could not find Roaster: " + id);
  }

  public RoasterNotFoundException() {
    super("There are not any roasters");

  }
}
