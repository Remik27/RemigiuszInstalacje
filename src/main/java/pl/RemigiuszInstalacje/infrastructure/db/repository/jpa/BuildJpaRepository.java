package pl.RemigiuszInstalacje.infrastructure.db.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.RemigiuszInstalacje.infrastructure.db.entity.BuildEntity;

public interface BuildJpaRepository extends JpaRepository<BuildEntity, Integer> {

}
