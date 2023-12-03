package pl.RemigiuszInstalacje.infrastructure.db.repository.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import pl.RemigiuszInstalacje.domain.Address;
import pl.RemigiuszInstalacje.infrastructure.db.entity.AddressEntity;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AddressEntityMapper {

    AddressEntity mapToEntity(Address address);

    Address mapFromEntity(AddressEntity addressEntity);
}
