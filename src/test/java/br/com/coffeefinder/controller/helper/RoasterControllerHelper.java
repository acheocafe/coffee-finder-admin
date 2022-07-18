package br.com.coffeefinder.controller.helper;

import br.com.coffeefinder.domain.dto.RoasterDto;
import com.fasterxml.jackson.databind.ObjectMapper;

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

  public static RoasterDto mockExpectedRoaster() {
    return RoasterDto.builder()
        .id("2")
        .name("Roaster2")
        .email("roaster2@gmail.com")
        .phone("219999992")
        .build();
  }

  public static RoasterDto mockInputRoaster() {
    return RoasterDto.builder()
        .id("2")
        .name("Roaster2")
        .email("roaster2@gmail.com")
        .phone("219999992")
        .build();
  }

  public static String asJsonString(final Object obj) {
    try {
      return new ObjectMapper().writeValueAsString(obj);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
