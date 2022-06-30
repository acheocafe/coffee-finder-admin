package br.com.coffeefinder.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import br.com.coffeefinder.exception.RoasterNotFoundException;
import br.com.coffeefinder.model.Roaster;
import br.com.coffeefinder.repository.RoasterRepository;

/**
 * RoasterService
 */
@Service
public class RoasterService {

  private final RoasterRepository roasterRepository;

  public RoasterService(final RoasterRepository roasterRepository) {
    this.roasterRepository = roasterRepository;
  }

  public Roaster save(final Roaster roaster) {
    return roasterRepository.save(roaster);
  }

  public Roaster findById(final Long id) {
    return roasterRepository.findById(id)
      .orElseThrow(() -> new RoasterNotFoundException());
  }

  public List<Roaster> findAll() {
    var allRoasters = Optional.of(roasterRepository.findAll());
    return allRoasters.orElseThrow(() -> new RoasterNotFoundException());
  }

  public Roaster updateRoaster(final Roaster roaster, final String roasterId) throws NotFoundException {
    return roasterRepository.findById(Long.valueOf(roasterId)).map(roasterResponse -> {
      roasterRepository.save(roaster);
      return Roaster.builder().id(roaster.getId()).build();
    }).orElseThrow(() -> new RoasterNotFoundException(roasterId));
  }

  public void deleteRoasterById(final Long roasterId) {
    roasterRepository.deleteById(roasterId);
  }

}
