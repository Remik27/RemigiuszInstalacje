package pl.RemigiuszInstalacje.infrastructure.db.repository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.RemigiuszInstalacje.business.dao.BuildDao;
import pl.RemigiuszInstalacje.domain.Build;
import pl.RemigiuszInstalacje.domain.exception.ResourceNotExistException;
import pl.RemigiuszInstalacje.infrastructure.db.entity.BuildEntity;
import pl.RemigiuszInstalacje.infrastructure.db.repository.jpa.BuildJpaRepository;
import pl.RemigiuszInstalacje.infrastructure.db.repository.mapper.BuildEntityMapper;

@Repository
@AllArgsConstructor
public class BuildRepository implements BuildDao {

    private final BuildJpaRepository buildJpaRepository;
    private final BuildEntityMapper buildEntityMapper;

    @Override
    public Build saveBuild(Build build) {
        BuildEntity buildEntity = buildEntityMapper.mapToEntity(build);

        return buildEntityMapper.mapFromEntity(buildJpaRepository.saveAndFlush(buildEntity));
    }

    @Override
    public Build findBuildById(Integer id) {
        return buildEntityMapper
                .mapFromEntity(
                        buildJpaRepository
                                .findById(id)
                                .orElseThrow(() ->
                                        new ResourceNotExistException("Build with id [%d] not exist".formatted(id))));
    }

    @Override
    public Build updateBuild(Build build) {
        BuildEntity buildEntity = buildEntityMapper.mapToEntity(build);

        return buildEntityMapper.mapFromEntity(buildJpaRepository.saveAndFlush(buildEntity));
    }

    @Override
    public boolean checkExistance(Integer id) {
        return buildJpaRepository.existsById(id);
    }
}
