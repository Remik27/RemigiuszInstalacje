package pl.RemigiuszInstalacje.business;

import lombok.AllArgsConstructor;
import pl.RemigiuszInstalacje.business.dao.BuildDao;
import pl.RemigiuszInstalacje.domain.Build;
import pl.RemigiuszInstalacje.domain.exception.ResourceAlreadyExistException;
import pl.RemigiuszInstalacje.domain.exception.ResourceNotExistException;

@AllArgsConstructor
public class BuildService {

    private final BuildDao buildDao;
    private final AddressService addressService;

    public Build addBuild(Build build) {
        if (addressService.checkExistence(build.address())) {
            throw new ResourceAlreadyExistException(
                    "Build with this address [%s] already exist".formatted(build.address().fullAddress()));
        }
        return buildDao.saveBuild(build);
    }

    public Build findBuildById(Integer buildId) {
        return buildDao.findBuildById(buildId);
    }

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
