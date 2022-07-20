package br.com.coffeefinder.service.helper;

import br.com.coffeefinder.domain.dto.RoasterDto;
import br.com.coffeefinder.domain.entity.RoasterEntity;
import java.util.List;
import java.util.Optional;

public class RoasterServiceHelper {

  public static Optional<RoasterEntity> mockRoasterRepositoryReturn() {
    return Optional.ofNullable(
        RoasterEntity.builder()
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

  public static List<RoasterEntity> mockFindAllRespository() {

    return List.of(
        RoasterEntity.builder()
            .id(2L)
            .name("Roaster2")
            .email("roaster2@outlook.com")
            .phone("552299922242")
            .build(),
        RoasterEntity.builder()
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

  public static RoasterEntity mockSaveRoasterRepository() {
    return RoasterEntity.builder()
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
