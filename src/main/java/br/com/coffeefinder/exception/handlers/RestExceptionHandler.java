package br.com.coffeefinder.exception.handlers;

import br.com.coffeefinder.exception.RoasterNotFoundException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandler {

  @ExceptionHandler(RoasterNotFoundException.class)
  @ResponseStatus(value = HttpStatus.NOT_FOUND)
  public ErrorInfo roasterNotFoundHandler(HttpServletRequest request, Exception ex) {
    return new ErrorInfo(request.getRequestURL().toString(), ex);
  }
}

