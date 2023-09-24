package pl.RemigiuszInstalacje.business;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.RemigiuszInstalacje.business.dao.AddressDao;
import pl.RemigiuszInstalacje.domain.Address;
import pl.RemigiuszInstalacje.util.DomainFixtures;

@ExtendWith(MockitoExtension.class)
class AddressServiceTest {

    @Mock
    AddressDao addressDao;

    @InjectMocks
    AddressService addressService;

    @Test
    void checkExistanceShouldReturnTrueWhenAddressIsFound() {
        //given
        Address address = DomainFixtures.someAddress();

        //when
        Mockito.when(addressDao.checkExistance(address)).thenReturn(true);
        boolean existance = addressService.checkExistence(address);

        //then
        Assertions.assertTrue(existance);
    }
    @Test
    void checkExistanceShouldReturnFalseWhenAddressIsNotFound() {
        //given
        Address address = DomainFixtures.someAddress();

        //when
        Mockito.when(addressDao.checkExistance(address)).thenReturn(false);
        boolean existance = addressService.checkExistence(address);

        //then
        Assertions.assertFalse(existance);
    }

}