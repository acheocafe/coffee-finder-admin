package br.com.coffeefinder.service.interfaces;

import br.com.coffeefinder.domain.dto.RoasterDto;
import java.util.List;

public interface RoasterService {
  RoasterDto save(final RoasterDto roaster);

  RoasterDto findById(final String id);

  List<RoasterDto> findAll();

  RoasterDto updateRoaster(final RoasterDto roaster);

  void deleteRoasterById(final String roasterId);
}
