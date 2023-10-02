package pl.RemigiuszInstalacje.infrastructure.db.entity;

import jakarta.persistence.*;
import lombok.Data;
import pl.RemigiuszInstalacje.domain.Stage;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Entity
@Data
@Table(name = "build")
public class BuildEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "stage")
    private Stage stage;

    @Column(name = "material_costs")
    private BigDecimal materialCosts;

    @Column(name = "work_costs")
    private BigDecimal workCosts;

    @Column(name = "start_date")
    private OffsetDateTime startDate;

    @Column(name = "deadline")
    private OffsetDateTime deadline;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id")
    private AddressEntity address;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private CustomerEntity customer;
}
