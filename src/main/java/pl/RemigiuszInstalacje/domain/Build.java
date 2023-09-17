package pl.RemigiuszInstalacje.domain;

import lombok.Builder;
import lombok.With;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Builder
@With
public record Build(
        Integer id,
        Address address,
        Stage stage,
        BigDecimal materialCosts,
        BigDecimal workCosts,
        OffsetDateTime startDate,
        OffsetDateTime deadline
) {
}
