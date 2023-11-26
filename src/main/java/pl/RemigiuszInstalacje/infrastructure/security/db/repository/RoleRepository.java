package pl.RemigiuszInstalacje.infrastructure.security.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.RemigiuszInstalacje.infrastructure.security.db.entity.RoleEntity;

import javax.management.relation.Role;
import java.util.Optional;

public interface RoleRepository extends JpaRepository<RoleEntity, Integer> {

    Optional<RoleEntity> findByRole(String role);
}
