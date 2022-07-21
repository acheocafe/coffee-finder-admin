package br.com.coffeefinder.domain.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/** VendorDto */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VendorDto {

  private String id;
  private String name;
  private String email;
  private String phone;
  private List<AddressDto> address;

  public Long idToLong() {
    return Long.valueOf(this.id);
  }
}
