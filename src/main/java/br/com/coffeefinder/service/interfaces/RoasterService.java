package br.com.coffeefinder.service.interfaces;

import java.util.List;

import br.com.coffeefinder.model.Roaster;

public interface RoasterService {
  public Roaster save(final Roaster roaster);

  public Roaster findById(final Long id);

  public List<Roaster> findAll();

  public Roaster updateRoaster(final Roaster roaster, final String roasterId) ;

  public void deleteRoasterById(final Long roasterId);

}
