package pl.RemigiuszInstalacje.infrastructure.security.api.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import pl.RemigiuszInstalacje.infrastructure.security.api.dto.RegisterRequest;
import pl.RemigiuszInstalacje.infrastructure.security.db.entity.UserEntity;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    UserEntity mapFromRegister(RegisterRequest registerRequest);



}
