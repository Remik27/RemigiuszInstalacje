package pl.RemigiuszInstalacje.infrastructure.security.api.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    @NotNull
    private String username;

    @Email
    @NotNull
    private String email;

    @Size(min = 5)
    @NotNull
    @Pattern(regexp = ".*\\d.*", message = "Password needs minimum one number.")
    private String password;

    @NotNull
    private String name;

    @NotNull
    private String surname;

    @NotNull
    private String phoneNumber;

}
