package br.com.coffeefinder.mockhelpers;

import java.util.List;

import br.com.coffeefinder.model.Roaster;

public class RoasterControllerHelper {

  public static List<Roaster> mockRoastersListExpected() {
    return List.of(Roaster.builder()
                   .id(1L)
                   .name("Roaster1")
                   .email("roaster@gmail.com")
                   .phone("219999991").build(),
                   Roaster.builder()
                   .id(2L)
                   .name("Roaster2")
                   .email("roaster2@gmail.com")
                   .phone("219999992").build());
  }

}
