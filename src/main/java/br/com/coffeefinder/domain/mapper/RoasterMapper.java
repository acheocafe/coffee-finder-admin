package br.com.coffeefinder.domain.mapper;

import br.com.coffeefinder.domain.dto.RoasterDto;
import br.com.coffeefinder.domain.entity.RoasterEntity;
import java.util.List;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoasterMapper {

  RoasterEntity toModel(RoasterDto dto);

  RoasterDto toDto(RoasterEntity model);

  List<RoasterDto> toDto(List<RoasterEntity> roasters);
}
