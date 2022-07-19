package br.com.coffeefinder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
public class CoffeeFinderApplication {
  public static void main(String[] args) {
    SpringApplication.run(CoffeeFinderApplication.class, args);
  }

}
