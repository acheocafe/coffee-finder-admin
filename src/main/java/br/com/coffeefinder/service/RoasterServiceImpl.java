package br.com.coffeefinder.service;

import br.com.coffeefinder.domain.dto.VendorDto;
import br.com.coffeefinder.domain.entity.VendorEntity;
import br.com.coffeefinder.domain.mapper.VendorMapper;
import br.com.coffeefinder.exception.RoasterNotFoundException;
import br.com.coffeefinder.repository.RoasterRepository;
import br.com.coffeefinder.service.interfaces.RoasterService;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/* RoasterService */
@Service
public class RoasterServiceImpl implements RoasterService {

  private final RoasterRepository roasterRepository;
  private final VendorMapper roasterMapper;

  public RoasterServiceImpl(RoasterRepository roasterRepository, VendorMapper roasterMapper) {
    this.roasterRepository = roasterRepository;
    this.roasterMapper = roasterMapper;
  }

  public VendorDto save(final VendorDto roaster) {
    return roasterMapper.toDto(roasterRepository.save(roasterMapper.toModel(roaster)));
  }

  public VendorDto findById(final String id) {
    VendorEntity roaster =
        roasterRepository
            .findById(Long.valueOf(id))
            .orElseThrow(() -> new RoasterNotFoundException(id));
    return roasterMapper.toDto(roaster);
  }

  public Page<VendorDto> findPageable(Pageable pageable) {
    var result = Optional.of(roasterRepository.findAll(pageable).map(roasterMapper::toDto));
    return result.orElseThrow(RoasterNotFoundException::new);
  }

  public List<VendorDto> findAll() {
    var allRoasters = Optional.of(roasterMapper.toDto(roasterRepository.findAll()));
    return allRoasters.orElseThrow(RoasterNotFoundException::new);
  }

  public VendorDto updateRoaster(final VendorDto roaster) {
    var updatedRoaster = roasterRepository.save(roasterMapper.toModel(roaster));
    return roasterMapper.toDto(updatedRoaster);
  }

  public void deleteRoasterById(final String roasterId) {
    roasterRepository.deleteById(Long.valueOf(roasterId));
  }
}
