package pl.RemigiuszInstalacje.business;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.RemigiuszInstalacje.business.dao.BuildDao;
import pl.RemigiuszInstalacje.domain.Build;
import pl.RemigiuszInstalacje.domain.exception.ResourceAlreadyExistException;
import pl.RemigiuszInstalacje.util.DomainFixtures;

@ExtendWith(MockitoExtension.class)
class BuildServiceTest {

    @Mock
    private BuildDao buildDao;
    @Mock
    private AddressService addressService;

    @InjectMocks
    private BuildService buildService;

    @Test
    void addTestShouldAddNewBuildCorrectly() {
        //given
        Build build = DomainFixtures.someBuild();

        //when
        Mockito.when(addressService.checkExistence(build.address())).thenReturn(false);
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

}