package br.com.coffeefinder.service.interfaces;

import br.com.coffeefinder.domain.dto.RoasterDto;
import java.util.List;

public interface RoasterService {
  public RoasterDto save(final RoasterDto roaster);

  public RoasterDto findById(final String id);

  public List<RoasterDto> findAll();

  public RoasterDto updateRoaster(final RoasterDto roaster, final String roasterId);

  public void deleteRoasterById(final Long roasterId);
}
