package br.com.coffeefinder.service.interfaces;

import br.com.coffeefinder.domain.dto.VendorDto;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface VendorService {
  VendorDto save(final VendorDto vendor);

  VendorDto findById(final String id);

  List<VendorDto> findAll();

  Page<VendorDto> findPageable(Pageable pageable);

  VendorDto updateVendor(final VendorDto vendor);

  void deleteVendorById(final String vendorId);
}
