package pl.RemigiuszInstalacje.api.dto;


import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import pl.RemigiuszInstalacje.domain.Stage;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Builder
public record BuildDto(
        Integer id,
        String city,
        String street,
        @Pattern(regexp = "\\d\\d-\\d\\d\\d")
        String postalCode,
        Stage stage,
        BigDecimal materialCosts,
        BigDecimal workCosts,
        OffsetDateTime startDate,
        OffsetDateTime deadline

) {
}
