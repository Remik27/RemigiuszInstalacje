package pl.RemigiuszInstalacje.infrastructure.security.api.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
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

    private String username;
    @Email
    private String email;

    @Size(min = 5)
    @Pattern(regexp = ".*\\d.*", message = "Password needs minimum one number.")
    private String password;

}
