package br.com.coffeefinder.controller.helper;

import br.com.coffeefinder.domain.dto.VendorDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

public class VendorControllerHelper {

  public static List<VendorDto> mockVendorsListExpected() {
    return List.of(
        VendorDto.builder()
            .id("1")
            .name("Vendor1")
            .email("vendor@gmail.com")
            .phone("219999991")
            .build(),
        VendorDto.builder()
            .id("2")
            .name("Vendor2")
            .email("vendor2@gmail.com")
            .phone("219999992")
            .build());
  }
public static Page<VendorDto> mockPageVendor(){
    return new PageImpl<>(mockVendorsListExpected());
}
  public static VendorDto mockExpectedVendor() {
    return VendorDto.builder()
        .id("2")
        .name("Vendor2")
        .email("vendor2@gmail.com")
        .phone("219999992")
        .build();
  }

  public static VendorDto mockInputVendor() {
    return VendorDto.builder()
        .id("2")
        .name("Vendor2")
        .email("vendor2@gmail.com")
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
