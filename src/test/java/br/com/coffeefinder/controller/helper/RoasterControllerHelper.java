package br.com.coffeefinder.controller.helper;

import br.com.coffeefinder.domain.dto.RoasterDto;
import br.com.coffeefinder.domain.model.Roaster;
import java.util.List;

public class RoasterControllerHelper {

  public static List<RoasterDto> mockRoastersListExpected() {
    return List.of(
        RoasterDto.builder()
            .id("1")
            .name("Roaster1")
            .email("roaster@gmail.com")
            .phone("219999991")
            .build(),
        RoasterDto.builder()
            .id("2")
            .name("Roaster2")
            .email("roaster2@gmail.com")
            .phone("219999992")
            .build());
  }


}
