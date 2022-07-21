package br.com.coffeefinder.domain.mapper;

import br.com.coffeefinder.domain.dto.AddressDto;
import br.com.coffeefinder.domain.entity.AddressEntity;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressMapper {

  AddressEntity toEntity(AddressDto dto);

  AddressDto  toDto(AddressEntity model);

  List<AddressDto> toDto(List<AddressEntity> vendors);

}
