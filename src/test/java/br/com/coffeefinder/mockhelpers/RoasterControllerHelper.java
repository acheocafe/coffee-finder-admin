package br.com.coffeefinder.mockhelpers;

import java.util.List;

import br.com.coffeefinder.domain.dto.RoasterDto;

public class RoasterControllerHelper {

  public static List<RoasterDto> mockRoastersListExpected() {
    return List.of(
        RoasterDto.builder()
            .id(1L)
            .name("Roaster1")
            .email("roaster@gmail.com")
            .phone("219999991")
            .build(),
        RoasterDto.builder()
            .id(2L)
            .name("Roaster2")
            .email("roaster2@gmail.com")
            .phone("219999992")
            .build());
  }
}
