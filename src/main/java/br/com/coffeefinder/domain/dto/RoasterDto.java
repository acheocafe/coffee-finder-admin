package br.com.coffeefinder.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/** RoasterDto */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RoasterDto {

  private String id;
  private String name;
  private String email;
  private String phone;

  public Long idToLong() {
    return Long.valueOf(this.id);
  }
}
