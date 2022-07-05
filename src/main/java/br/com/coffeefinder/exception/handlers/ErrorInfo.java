package br.com.coffeefinder.exception.handlers;

public class ErrorInfo {
  public String url;
  public String message;

  public ErrorInfo(String url, Exception ex) {
    this.url = url;
    this.message = ex.getMessage();
  }
}
