package pl.RemigiuszInstalacje.business;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.RemigiuszInstalacje.business.dao.BuildDao;
import pl.RemigiuszInstalacje.domain.Address;
import pl.RemigiuszInstalacje.domain.Build;
import pl.RemigiuszInstalacje.domain.Customer;
import pl.RemigiuszInstalacje.domain.exception.ResourceAlreadyExistException;
import pl.RemigiuszInstalacje.domain.exception.ResourceNotExistException;
import pl.RemigiuszInstalacje.util.DomainFixtures;

@ExtendWith(MockitoExtension.class)
class BuildServiceTest {

    @Mock
    private BuildDao buildDao;
    @Mock
    private AddressService addressService;

    @Mock
    private CustomerService customerService;

    @InjectMocks
    private BuildService buildService;

    @Test
    void addTestShouldAddNewBuildCorrectly() {
        //given
        Build build = DomainFixtures.someBuild();
        Customer investor = DomainFixtures.someCustomer();
        Address address = DomainFixtures.someAddress();

        //when
        Mockito.when(addressService.checkExistence(build.address())).thenReturn(false);
        Mockito.when(addressService.saveAddress(build.address())).thenReturn(address);
        Mockito.when(customerService.findCustomerByEmail(build.investor().email())).thenReturn(investor);
        Mockito.when(buildDao.saveBuild(build)).thenReturn(build);
        Build buildAdded = buildService.addBuild(build);

        //then
        Assertions.assertEquals(build, buildAdded);

    }

    @Test
    void addTestShouldThrowWhenAddressAlreadyExist() {
        //given
        Build build = DomainFixtures.someBuild();
        String message = "Build with this address [%s] already exist".formatted(build.address().fullAddress());

        //when
        Mockito.when(addressService.checkExistence(build.address())).thenReturn(true);
        ResourceAlreadyExistException exception =
                Assertions.assertThrows(ResourceAlreadyExistException.class, () -> buildService.addBuild(build));
        //then
        Assertions.assertEquals(message, exception.getMessage());

    }
    @Test
    void findBuildByIdShouldReturnBuildCorrectly(){
        //given
        Build build = DomainFixtures.someBuild();
        Integer id = build.id();

        //when
        Mockito.when(buildDao.findBuildById(id)).thenReturn(build);
        Build buildById = buildService.findBuildById(id);

        //then
        Assertions.assertEquals(build, buildById);

    }
    @Test
    void findBuildByIdShouldThrowWhenBuildNotExist(){
        //given
        Integer id = 1;
        String message = "Build with id [%d] not exist".formatted(id);

        //when
        Mockito.when(buildDao.findBuildById(id)).thenThrow(new ResourceNotExistException(message));
        ResourceNotExistException exception =
                Assertions.assertThrows(ResourceNotExistException.class, () -> buildService.findBuildById(id));

        //then
        Assertions.assertEquals(message, exception.getMessage());
    }

    @Test
    void updateBuildShouldUpdateCorrectly(){
        //given
        Build build = DomainFixtures.someBuild();

        //when
        Mockito.when(buildDao.saveBuild(build)).thenReturn(build);
        Mockito.when(buildDao.checkExistance(build.id())).thenReturn(true);
        Build buildUpdated = buildService.updateBuild(build);

        //then
        Assertions.assertEquals(build, buildUpdated);
    }

    @Test
    void updateBuildShouldThrowWhenBuildNotExist(){
        //given
        Build build = DomainFixtures.someBuild();
        String message = "Build with id [%d] not exist".formatted(build.id());

        //when
        Mockito.when(buildDao.checkExistance(build.id())).thenReturn(false);
        ResourceNotExistException exception =
                Assertions.assertThrows(ResourceNotExistException.class, () -> buildService.updateBuild(build));

        //then
        Assertions.assertEquals(message, exception.getMessage());
    }

}