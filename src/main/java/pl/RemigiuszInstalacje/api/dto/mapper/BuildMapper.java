package pl.RemigiuszInstalacje.api.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.RemigiuszInstalacje.api.dto.BuildDto;
import pl.RemigiuszInstalacje.domain.Address;
import pl.RemigiuszInstalacje.domain.Build;
import pl.RemigiuszInstalacje.domain.Customer;

@Mapper(componentModel = "spring")
public interface BuildMapper {

    @Mapping(target = "investor", expression = "java(mapCustomer(buildDto.customerEmail()))")
    @Mapping(target = "address",
            expression = "java(mapAddress(buildDto.city(), buildDto.street(), buildDto.postalCode()))")
    Build mapFromDto(BuildDto buildDto);

    @Mapping(target = "customerEmail", source = "buildAdded.investor.email")
    @Mapping(target = "city", source = "buildAdded.address.city")
    @Mapping(target = "street", source = "buildAdded.address.street")
    @Mapping(target = "postalCode", source = "buildAdded.address.postalCode")
    BuildDto mapToDto(Build buildAdded);

    default Customer mapCustomer(String customerEmail) {
        return Customer.builder()
                .email(customerEmail)
                .build();
    }

    default Address mapAddress(String city, String street, String postalCode) {
        return Address.builder()
                .city(city)
                .street(street)
                .postalCode(postalCode)
                .fullAddress(city
                        .concat(", ")
                        .concat(street)
                        .concat(" ")
                        .concat(postalCode))
                .build();
    }

}
