package br.com.coffeefinder.repository;

import br.com.coffeefinder.domain.entity.RoasterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/** RoasterRepository */
@Repository
public interface RoasterRepository extends JpaRepository<RoasterEntity, Long> {}
