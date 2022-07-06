package br.com.coffeefinder.mockhelpers.service;

import br.com.coffeefinder.domain.dto.RoasterDto;
import br.com.coffeefinder.domain.model.Roaster;
import java.util.Optional;

public class RoasterServiceHelper {

  public static Optional<Roaster> mockRoasterRepositoryReturn() {
    return Optional.ofNullable(
        Roaster.builder()
            .id(2L)
            .name("Roaster2")
            .email("roaster2@outlook.com")
            .phone("21981582550")
            .build());
  }

  public static RoasterDto mockExpectedRoaster() {
    return RoasterDto.builder()
        .id("2")
        .name("Roaster2")
        .email("roaster2@outlook.com")
        .phone("21981582550")
        .build();
  }
}
