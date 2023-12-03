package pl.RemigiuszInstalacje.infrastructure.db.repository.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import pl.RemigiuszInstalacje.domain.Customer;
import pl.RemigiuszInstalacje.infrastructure.db.entity.CustomerEntity;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CustomerEntityMapper {
    Customer mapFromEntity(CustomerEntity customerEntity);

    CustomerEntity mapToEntity(Customer customer);
}
