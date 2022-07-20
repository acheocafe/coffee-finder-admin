package br.com.coffeefinder.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddressDto {
  private Long id;
  private String streetAdress;
  private String city;
  private String state;
  private String zipCode;
}
