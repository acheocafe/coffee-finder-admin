package br.com.coffeefinder.service.interfaces;

import br.com.coffeefinder.domain.dto.RoasterDto;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface RoasterService {
  RoasterDto save(final RoasterDto roaster);

  RoasterDto findById(final String id);

  List<RoasterDto> findAll();

  Page<RoasterDto> findPageable(Pageable pageable);

  RoasterDto updateRoaster(final RoasterDto roaster);

  void deleteRoasterById(final String roasterId);
}
