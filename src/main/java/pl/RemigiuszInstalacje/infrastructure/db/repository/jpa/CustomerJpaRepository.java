package pl.RemigiuszInstalacje.infrastructure.db.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.RemigiuszInstalacje.infrastructure.db.entity.CustomerEntity;

public interface CustomerJpaRepository extends JpaRepository<CustomerEntity, Integer> {
}
