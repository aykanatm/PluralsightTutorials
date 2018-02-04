package org.murat.pluralsight.repository;

import org.murat.pluralsight.model.Shipwreck;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShipwreckRepository extends JpaRepository<Shipwreck, Long>{
}
