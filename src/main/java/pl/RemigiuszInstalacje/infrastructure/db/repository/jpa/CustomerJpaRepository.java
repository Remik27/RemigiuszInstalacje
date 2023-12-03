package pl.RemigiuszInstalacje.infrastructure.db.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.RemigiuszInstalacje.infrastructure.db.entity.CustomerEntity;

import java.util.Optional;

public interface CustomerJpaRepository extends JpaRepository<CustomerEntity, Integer> {
    Optional<CustomerEntity> findByEmail(String email);
}
