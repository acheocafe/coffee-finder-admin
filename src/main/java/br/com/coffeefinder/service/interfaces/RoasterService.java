package br.com.coffeefinder.service.interfaces;

import br.com.coffeefinder.domain.dto.VendorDto;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface RoasterService {
  VendorDto save(final VendorDto roaster);

  VendorDto findById(final String id);

  List<VendorDto> findAll();

  Page<VendorDto> findPageable(Pageable pageable);

  VendorDto updateRoaster(final VendorDto roaster);

  void deleteRoasterById(final String roasterId);
}
