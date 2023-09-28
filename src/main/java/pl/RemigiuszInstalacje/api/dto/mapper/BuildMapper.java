package pl.RemigiuszInstalacje.api.dto.mapper;

import org.mapstruct.Mapper;
import pl.RemigiuszInstalacje.api.dto.BuildDto;
import pl.RemigiuszInstalacje.domain.Build;

@Mapper(componentModel = "spring")
public interface BuildMapper {
    Build mapFromDto(BuildDto buildDto);

    BuildDto mapToDto(Build buildAdded);
}
