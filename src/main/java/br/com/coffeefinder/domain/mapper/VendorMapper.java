package br.com.coffeefinder.domain.mapper;

import br.com.coffeefinder.domain.dto.AddressDto;
import br.com.coffeefinder.domain.dto.VendorDto;
import br.com.coffeefinder.domain.entity.AddressEntity;
import br.com.coffeefinder.domain.entity.VendorEntity;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface VendorMapper {

  @Mapping(source = "address", target = "addressEntities")
  VendorEntity toEntity(VendorDto dto);

  @Mapping(source = "addressEntities", target = "address")
  VendorDto toDto(VendorEntity model);

  List<VendorDto> toDto(List<VendorEntity> vendors);

}
