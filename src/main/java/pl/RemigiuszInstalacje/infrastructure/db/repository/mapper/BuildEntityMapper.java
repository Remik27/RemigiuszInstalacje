package pl.RemigiuszInstalacje.infrastructure.db.repository.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import pl.RemigiuszInstalacje.domain.Build;
import pl.RemigiuszInstalacje.infrastructure.db.entity.BuildEntity;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BuildEntityMapper {


    BuildEntity mapToEntity(Build build);

    Build mapFromEntity(BuildEntity saveAndFlush);
}
