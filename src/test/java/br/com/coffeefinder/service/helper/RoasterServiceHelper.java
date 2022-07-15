package br.com.coffeefinder.service.helper;

import br.com.coffeefinder.domain.dto.RoasterDto;
import br.com.coffeefinder.domain.model.Roaster;
import java.util.List;
import java.util.Optional;

public class RoasterServiceHelper {

  public static Optional<Roaster> mockRoasterRepositoryReturn() {
    return Optional.ofNullable(
        Roaster.builder()
            .id(2L)
            .name("Roaster2")
            .email("roaster2@outlook.com")
            .phone("552299922244")
            .build());
  }

  public static RoasterDto mockExpectedRoaster() {
    return RoasterDto.builder()
        .id("2")
        .name("Roaster2")
        .email("roaster2@outlook.com")
        .phone("552299922244")
        .build();
  }

  public static List<RoasterDto> mockExpectedFindAll() {

    return List.of(
        RoasterDto.builder()
            .id("2")
            .name("Roaster2")
            .email("roaster2@outlook.com")
            .phone("552299922242")
            .build(),
        RoasterDto.builder()
            .id("3")
            .name("Roaster3")
            .email("roaster3@outlook.com")
            .phone("552299922243")
            .build());
  }

  public static List<Roaster> mockFindAllRespository() {

    return List.of(
        Roaster.builder()
            .id(2L)
            .name("Roaster2")
            .email("roaster2@outlook.com")
            .phone("552299922242")
            .build(),
        Roaster.builder()
            .id(3L)
            .name("Roaster3")
            .email("roaster3@outlook.com")
            .phone("552299922243")
            .build());
  }

  public static RoasterDto mockExpectedSaveRoaster() {
    return RoasterDto.builder()
        .id("1")
        .name("Roaster2")
        .email("roaster2@outlook.com")
        .phone("552299922244")
        .build();
  }

  public static Roaster mockSaveRoasterRepository() {
    return Roaster.builder()
        .id(2L)
        .name("Roaster2")
        .email("roaster2@outlook.com")
        .phone("552299922244")
        .build();
  }

  public static RoasterDto mockInputRoasterDto() {
    return RoasterDto.builder()
        .id("2")
        .name("Roaster2")
        .email("roaster2@outlook.com")
        .phone("552299922244")
        .build();
  }
}
