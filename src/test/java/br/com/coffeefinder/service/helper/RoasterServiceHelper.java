package br.com.coffeefinder.service.helper;

import br.com.coffeefinder.domain.dto.VendorDto;
import br.com.coffeefinder.domain.entity.VendorEntity;
import java.util.List;
import java.util.Optional;

public class RoasterServiceHelper {

  public static Optional<VendorEntity> mockRoasterRepositoryReturn() {
    return Optional.ofNullable(
        VendorEntity.builder()
            .id(2L)
            .name("Roaster2")
            .email("roaster2@outlook.com")
            .phone("552299922244")
            .build());
  }

  public static VendorDto mockExpectedRoaster() {
    return VendorDto.builder()
        .id("2")
        .name("Roaster2")
        .email("roaster2@outlook.com")
        .phone("552299922244")
        .build();
  }

  public static List<VendorDto> mockExpectedFindAll() {

    return List.of(
        VendorDto.builder()
            .id("2")
            .name("Roaster2")
            .email("roaster2@outlook.com")
            .phone("552299922242")
            .build(),
        VendorDto.builder()
            .id("3")
            .name("Roaster3")
            .email("roaster3@outlook.com")
            .phone("552299922243")
            .build());
  }

  public static List<VendorEntity> mockFindAllRespository() {

    return List.of(
        VendorEntity.builder()
            .id(2L)
            .name("Roaster2")
            .email("roaster2@outlook.com")
            .phone("552299922242")
            .build(),
        VendorEntity.builder()
            .id(3L)
            .name("Roaster3")
            .email("roaster3@outlook.com")
            .phone("552299922243")
            .build());
  }

  public static VendorDto mockExpectedSaveRoaster() {
    return VendorDto.builder()
        .id("1")
        .name("Roaster2")
        .email("roaster2@outlook.com")
        .phone("552299922244")
        .build();
  }

  public static VendorEntity mockSaveRoasterRepository() {
    return VendorEntity.builder()
        .id(2L)
        .name("Roaster2")
        .email("roaster2@outlook.com")
        .phone("552299922244")
        .build();
  }

  public static VendorDto mockInputRoasterDto() {
    return VendorDto.builder()
        .id("2")
        .name("Roaster2")
        .email("roaster2@outlook.com")
        .phone("552299922244")
        .build();
  }
}
