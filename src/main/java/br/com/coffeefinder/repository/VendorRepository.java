package br.com.coffeefinder.repository;

import br.com.coffeefinder.domain.entity.VendorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/** VendorRepository */
@Repository
public interface VendorRepository
    extends JpaRepository<VendorEntity, Long>, PagingAndSortingRepository<VendorEntity, Long> {}