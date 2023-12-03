package pl.RemigiuszInstalacje.infrastructure.db.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.RemigiuszInstalacje.infrastructure.db.entity.AddressEntity;

import java.util.Optional;

public interface AddressJpaRepository extends JpaRepository<AddressEntity, Integer> {

 Optional<AddressEntity> findByFullAddress(String fullAddress);
}
