package pl.RemigiuszInstalacje.domain;

import lombok.Builder;
import lombok.With;

@Builder
@With
public record Customer (

    Integer id,
    String name,
    String surname,
    String email,
    String phoneNumber
){

}
