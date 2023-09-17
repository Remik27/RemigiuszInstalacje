package pl.RemigiuszInstalacje.domain;

import lombok.Builder;
import lombok.With;

@With
@Builder
public record Address(String city, String street, String postalCode, String fullAddress) {

}
