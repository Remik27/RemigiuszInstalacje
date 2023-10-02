package pl.RemigiuszInstalacje.infrastructure.db.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "address")
public class AddressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "city")
    private String city;

    @Column(name = "street")
    private String street;

    @Column(name = "postal_code")
    private String postalCode;

    @Column(name = "full_address")
    private String fullAddress;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "address")
    private BuildEntity build;
}
