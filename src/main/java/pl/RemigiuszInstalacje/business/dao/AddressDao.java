package pl.RemigiuszInstalacje.business.dao;

import pl.RemigiuszInstalacje.domain.Address;

public interface AddressDao {
    boolean checkExistance(Address address);
}
