package br.com.coffeefinder.service.helper;

import br.com.coffeefinder.domain.dto.AddressDto;
import br.com.coffeefinder.domain.dto.VendorDto;
import br.com.coffeefinder.domain.entity.AddressEntity;
import br.com.coffeefinder.domain.entity.VendorEntity;
import java.util.List;
import java.util.Optional;

public class VendorServiceHelper {

  public static Optional<VendorEntity> mockVendorRepositoryReturn() {
    return Optional.ofNullable(
        VendorEntity.builder()
            .id(2L)
            .name("Vendor2")
            .email("vendor2@outlook.com")
            .phone("552299922244")
            .address(mockAddressRepositoryReturn())
            .build());
  }

  public static AddressEntity mockAddressRepositoryReturn() {
    return AddressEntity.builder()
        .id(1L)
        .streetAdress("rua teste,8")
        .city("Rio")
        .state("RJ")
        .zipCode("25444-323")
        .build();
  }

  public static AddressDto mockExpectedAddressDto() {
    return AddressDto.builder()
        .id("1")
        .streetAdress("rua teste,8")
        .city("Rio")
        .state("RJ")
        .zipCode("25444-323")
        .build();
  }

  public static VendorDto mockExpectedVendor() {
    return VendorDto.builder()
        .id("2")
        .name("Vendor2")
        .email("vendor2@outlook.com")
        .phone("552299922244")
        .addressDto(mockExpectedAddressDto())
        .build();
  }

  public static List<VendorDto> mockExpectedFindAll() {

    return List.of(
        VendorDto.builder()
            .id("2")
            .name("Vendor2")
            .email("vendor2@outlook.com")
            .phone("552299922242")
            .build(),
        VendorDto.builder()
            .id("3")
            .name("Vendor3")
            .email("vendor3@outlook.com")
            .phone("552299922243")
            .build());
  }

  public static List<VendorEntity> mockFindAllRespository() {

    return List.of(
        VendorEntity.builder()
            .id(2L)
            .name("Vendor2")
            .email("vendor2@outlook.com")
            .phone("552299922242")
            .build(),
        VendorEntity.builder()
            .id(3L)
            .name("Vendor3")
            .email("vendor3@outlook.com")
            .phone("552299922243")
            .build());
  }

  public static VendorDto mockExpectedSaveVendor() {
    return VendorDto.builder()
        .id("1")
        .name("Vendor2")
        .email("vendor2@outlook.com")
        .phone("552299922244")
        .build();
  }

  public static VendorEntity mockSaveVendorRepository() {
    return VendorEntity.builder()
        .id(2L)
        .name("Vendor2")
        .email("vendor2@outlook.com")
        .phone("552299922244")
        .build();
  }

  public static VendorDto mockInputVendorDto() {
    return VendorDto.builder()
        .id("2")
        .name("Vendor2")
        .email("vendor2@outlook.com")
        .phone("552299922244")
        .build();
  }
}
