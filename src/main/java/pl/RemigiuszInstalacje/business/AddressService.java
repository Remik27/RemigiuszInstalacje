package pl.RemigiuszInstalacje.business;

import lombok.AllArgsConstructor;
import pl.RemigiuszInstalacje.business.dao.AddressDao;
import pl.RemigiuszInstalacje.domain.Address;

@AllArgsConstructor
public class AddressService {

    private final AddressDao addressDao;
    public boolean checkExistence(Address address) {
        return addressDao.checkExistance(address);
    }
}
