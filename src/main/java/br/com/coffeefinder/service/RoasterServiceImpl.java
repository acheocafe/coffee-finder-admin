package br.com.coffeefinder.service;

import br.com.coffeefinder.domain.dto.RoasterDto;
import br.com.coffeefinder.domain.mapper.RoasterMapper;
import br.com.coffeefinder.domain.entity.RoasterEntity;
import br.com.coffeefinder.exception.RoasterNotFoundException;
import br.com.coffeefinder.repository.RoasterRepository;
import br.com.coffeefinder.service.interfaces.RoasterService;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

/* RoasterService */
@Service
public class RoasterServiceImpl implements RoasterService {

  private final RoasterRepository roasterRepository;
  private final RoasterMapper roasterMapper;

  public RoasterServiceImpl(RoasterRepository roasterRepository, RoasterMapper roasterMapper) {
    this.roasterRepository = roasterRepository;
    this.roasterMapper = roasterMapper;
  }

  public RoasterDto save(final RoasterDto roaster) {

    return roasterMapper.toDto(roasterRepository.save(roasterMapper.toModel(roaster)));
  }

  public RoasterDto findById(final String id) {
    RoasterEntity roaster =
        roasterRepository
            .findById(Long.valueOf(id))
            .orElseThrow(() -> new RoasterNotFoundException(id));
    return roasterMapper.toDto(roaster);
  }

  public List<RoasterDto> findAll() {
    var allRoasters = Optional.of(roasterMapper.toDto(roasterRepository.findAll()));
    return allRoasters.orElseThrow(RoasterNotFoundException::new);
  }

  public RoasterDto updateRoaster(final RoasterDto roaster) {
    var updatedRoaster = roasterRepository.save(roasterMapper.toModel(roaster));
    return roasterMapper.toDto(updatedRoaster);
  }

  public void deleteRoasterById(final String roasterId) {
    roasterRepository.deleteById(Long.valueOf(roasterId));
  }
}
