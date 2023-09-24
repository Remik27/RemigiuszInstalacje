package pl.RemigiuszInstalacje.domain;

import lombok.Builder;

@Builder
public record Customer (

    Integer id,
    String name,
    String surname,
    String email,
    String phoneNumber
){

}
