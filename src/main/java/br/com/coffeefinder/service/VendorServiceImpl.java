package br.com.coffeefinder.service;

import br.com.coffeefinder.domain.dto.VendorDto;
import br.com.coffeefinder.domain.entity.VendorEntity;
import br.com.coffeefinder.domain.mapper.VendorMapper;
import br.com.coffeefinder.exception.VendorNotFoundException;
import br.com.coffeefinder.repository.VendorRepository;
import br.com.coffeefinder.service.interfaces.VendorService;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/* VendorService */
@Service
public class VendorServiceImpl implements VendorService {

  private final VendorRepository vendorRepository;
  private final VendorMapper vendorMapper;

  public VendorServiceImpl(VendorRepository vendorRepository, VendorMapper vendorMapper) {
    this.vendorRepository = vendorRepository;
    this.vendorMapper = vendorMapper;
  }

  public VendorDto save(final VendorDto vendor) {
    return vendorMapper.toDto(vendorRepository.save(vendorMapper.toEntity(vendor)));
  }

  public VendorDto findById(final String id) {
    VendorEntity vendor =
        vendorRepository
            .findById(Long.valueOf(id))
            .orElseThrow(() -> new VendorNotFoundException(id));
    return vendorMapper.toDto(vendor);
  }

  public Page<VendorDto> findPageable(Pageable pageable) {
    var result = Optional.of(vendorRepository.findAll(pageable).map(vendorMapper::toDto));
    return result.orElseThrow(VendorNotFoundException::new);
  }

  public List<VendorDto> findAll() {
    var allVendors = Optional.of(vendorMapper.toDto(vendorRepository.findAll()));
    return allVendors.orElseThrow(VendorNotFoundException::new);
  }

  public VendorDto updateVendor(final VendorDto vendor) {
    var updatedVendor = vendorRepository.save(vendorMapper.toEntity(vendor));
    return vendorMapper.toDto(updatedVendor);
  }

  public void deleteVendorById(final String vendorId) {
    vendorRepository.deleteById(Long.valueOf(vendorId));
  }
}
