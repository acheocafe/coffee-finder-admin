package br.com.coffeefinder.domain.mapper;

import br.com.coffeefinder.domain.dto.RoasterDto;
import br.com.coffeefinder.domain.model.Roaster;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoasterMapper {

  Roaster toModel(RoasterDto dto);

  RoasterDto toDto(Roaster model);

  List<RoasterDto> toDto(List<Roaster> roasters);
}
