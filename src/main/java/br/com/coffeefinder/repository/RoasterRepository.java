package br.com.coffeefinder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.coffeefinder.model.Roaster;

/**
 * RoasterRepository
 */
@Repository
public interface RoasterRepository extends JpaRepository<Roaster,Long>{

}
