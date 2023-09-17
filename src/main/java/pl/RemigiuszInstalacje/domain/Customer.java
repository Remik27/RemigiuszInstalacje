package pl.RemigiuszInstalacje.domain;

public record Customer (

    Integer id,
    String name,
    String surname,
    String email,
    String phoneNumber
){

}
