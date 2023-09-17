package pl.RemigiuszInstalacje.business.dao;

import pl.RemigiuszInstalacje.domain.Build;

public interface BuildDao {
    Build saveBuild(Build build);

    Build findBuildById(Integer id);
}
