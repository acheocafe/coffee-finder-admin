package br.com.coffeefinder.service;

import br.com.coffeefinder.domain.dto.RoasterDto;
import br.com.coffeefinder.domain.mapper.RoasterMapper;
import br.com.coffeefinder.domain.model.Roaster;
import br.com.coffeefinder.exception.RoasterNotFoundException;
import br.com.coffeefinder.repository.RoasterRepository;
import br.com.coffeefinder.service.interfaces.RoasterService;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

/** RoasterService */
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
    Roaster roaster =
        roasterRepository
            .findById(Long.valueOf(id))
            .orElseThrow(() -> new RoasterNotFoundException(id));
    return roasterMapper.toDto(roaster);
  }

  public List<RoasterDto> findAll() {
    var allRoasters = Optional.of(roasterMapper.toDto(roasterRepository.findAll()));
    return allRoasters.orElseThrow(RoasterNotFoundException::new);
  }

  public RoasterDto updateRoaster(final RoasterDto roaster, final String roasterId) {
    return roasterRepository
        .findById(Long.valueOf(roasterId))
        .map(
            roasterResponse -> {
              var roasterModel = roasterRepository.save(roasterMapper.toModel(roaster));
              return roasterMapper.toDto(roasterModel);
            })
        .orElseThrow(() -> new RoasterNotFoundException(roasterId));
  }

  public void deleteRoasterById(final Long roasterId) {
    roasterRepository.deleteById(roasterId);
  }
}
