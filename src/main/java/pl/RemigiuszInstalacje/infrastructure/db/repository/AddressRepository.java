package pl.RemigiuszInstalacje.infrastructure.db.repository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.RemigiuszInstalacje.business.dao.AddressDao;
import pl.RemigiuszInstalacje.domain.Address;
import pl.RemigiuszInstalacje.infrastructure.db.entity.AddressEntity;
import pl.RemigiuszInstalacje.infrastructure.db.repository.jpa.AddressJpaRepository;
import pl.RemigiuszInstalacje.infrastructure.db.repository.mapper.AddressEntityMapper;

@AllArgsConstructor
@Repository
public class AddressRepository implements AddressDao {

    private final AddressJpaRepository addressJpaRepository;
    private final AddressEntityMapper addressEntityMapper;
    @Override
    public boolean checkExistance(Address address) {
        return addressJpaRepository.findByFullAddress(address.fullAddress()).isPresent();
    }

    @Override
    public Address saveAddress(Address address) {
        AddressEntity addressEntity = addressEntityMapper.mapToEntity(address);
        return addressEntityMapper.mapFromEntity(addressJpaRepository.saveAndFlush(addressEntity));
    }
}
