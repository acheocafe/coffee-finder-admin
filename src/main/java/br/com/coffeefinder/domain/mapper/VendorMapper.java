package br.com.coffeefinder.domain.mapper;

import br.com.coffeefinder.domain.dto.VendorDto;
import br.com.coffeefinder.domain.entity.VendorEntity;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VendorMapper {

  VendorEntity toModel(VendorDto dto);

  VendorDto toDto(VendorEntity model);

  List<VendorDto> toDto(List<VendorEntity> vendors);

}
