package pl.RemigiuszInstalacje.infrastructure.db.repository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.RemigiuszInstalacje.business.dao.AddressDao;
import pl.RemigiuszInstalacje.domain.Address;
import pl.RemigiuszInstalacje.infrastructure.db.repository.jpa.AddressJpaRepository;

@AllArgsConstructor
@Repository
public class AddressRepository implements AddressDao {

    private final AddressJpaRepository addressJpaRepository;
    @Override
    public boolean checkExistance(Address address) {
        return addressJpaRepository.existsById(address.id());
    }
}
