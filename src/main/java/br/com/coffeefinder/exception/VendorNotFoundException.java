package br.com.coffeefinder.exception;

public class VendorNotFoundException extends RuntimeException {

  public VendorNotFoundException(String id) {
    super("Could not find Vendor: " + id);
  }

  public VendorNotFoundException() {
    super("There are not any vendors");
  }
}
