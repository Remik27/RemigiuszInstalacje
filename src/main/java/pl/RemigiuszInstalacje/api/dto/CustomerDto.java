package pl.RemigiuszInstalacje.api.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;

@Builder
public record CustomerDto(
        Integer id,
        String name,
        String surname,
        @Email
        String email,
        @Pattern(regexp = "\\d\\d\\d\\d\\d\\d\\d\\d\\d")
        String phoneNumber

) {


}
