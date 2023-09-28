package pl.RemigiuszInstalacje.api.dto.mapper;

import org.mapstruct.Mapper;
import pl.RemigiuszInstalacje.api.dto.CustomerDto;
import pl.RemigiuszInstalacje.domain.Customer;
@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerDto mapToDto(Customer customer) ;

    Customer mapFromDto(CustomerDto customerDto);
}
