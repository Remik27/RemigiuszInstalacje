package pl.RemigiuszInstalacje.business;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.RemigiuszInstalacje.business.dao.AddressDao;
import pl.RemigiuszInstalacje.domain.Address;

@Service
@AllArgsConstructor
public class AddressService {

    private final AddressDao addressDao;
    public boolean checkExistence(Address address) {
        return addressDao.checkExistance(address);
    }

    public Address saveAddress(Address address) {
        return addressDao.saveAddress(address);
    }
}
