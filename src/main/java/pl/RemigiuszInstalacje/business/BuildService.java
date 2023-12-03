package pl.RemigiuszInstalacje.business;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.RemigiuszInstalacje.business.dao.BuildDao;
import pl.RemigiuszInstalacje.domain.Address;
import pl.RemigiuszInstalacje.domain.Build;
import pl.RemigiuszInstalacje.domain.Customer;
import pl.RemigiuszInstalacje.domain.exception.ResourceAlreadyExistException;
import pl.RemigiuszInstalacje.domain.exception.ResourceNotExistException;
@Service
@AllArgsConstructor
public class BuildService {

    private final BuildDao buildDao;
    private final AddressService addressService;
    private final CustomerService customerService;

    @Transactional
    public Build addBuild(Build build) {
        if (addressService.checkExistence(build.address())) {
            throw new ResourceAlreadyExistException(
                    "Build with this address [%s] already exist".formatted(build.address().fullAddress()));
        }
        Address address = addressService.saveAddress(build.address());
        Customer customer = customerService.findCustomerByEmail(build.investor().email());
        return buildDao.saveBuild(build.withAddress(address).withInvestor(customer));
    }

    public Build findBuildById(Integer buildId) {
        return buildDao.findBuildById(buildId);
    }

    @Transactional
    public Build updateBuild(Build build) {
        if (checkIdExistance(build.id())) {
            return buildDao.saveBuild(build);
        }
        throw new ResourceNotExistException("Build with id [%d] not exist".formatted(build.id()));
    }

    private boolean checkIdExistance(Integer id) {
        if (id == null) {
            return false;
        } else return buildDao.checkExistance(id);
    }
}
