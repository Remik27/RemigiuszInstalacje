package pl.RemigiuszInstalacje.infrastructure.db.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.RemigiuszInstalacje.infrastructure.db.entity.AddressEntity;

public interface AddressJpaRepository extends JpaRepository<AddressEntity, Integer> {


}
