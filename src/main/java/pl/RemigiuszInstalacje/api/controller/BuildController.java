package pl.RemigiuszInstalacje.api.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.RemigiuszInstalacje.api.dto.BuildDto;
import pl.RemigiuszInstalacje.api.dto.CustomerDto;
import pl.RemigiuszInstalacje.api.dto.mapper.BuildMapper;
import pl.RemigiuszInstalacje.business.BuildService;
import pl.RemigiuszInstalacje.domain.Build;
import pl.RemigiuszInstalacje.domain.Customer;

@RestController
@RequestMapping(BuildController.BUILD_API)
@AllArgsConstructor
public class BuildController {

    public static final String BUILD_API = "/build";

    public static final String ADD_NEW_BUILD = "/add-new-build";
    public static final String GET_BUILD = "/get-build";
    public static final String UPDATE_BUILD = "/update-build";
    private final BuildMapper buildMapper;
    private final BuildService buildService;

    @PostMapping(ADD_NEW_BUILD)
    public ResponseEntity<BuildDto> addBuild(@RequestBody BuildDto buildDto) {

        Build build = buildMapper.mapFromDto(buildDto);

        Build buildAdded = buildService.addBuild(build);

        return ResponseEntity.ok(buildMapper.mapToDto(buildAdded));

    }

    @GetMapping(GET_BUILD)
    public ResponseEntity<BuildDto> getBuild(@PathVariable Integer buildId){
        Build build = buildService.findBuildById(buildId);
        BuildDto buildDto = buildMapper.mapToDto(build);

        return ResponseEntity.ok(buildDto);
    }

    @PatchMapping(UPDATE_BUILD)
    public ResponseEntity<BuildDto> updateBuild(
            @PathVariable Integer buildId,
            @RequestBody BuildDto buildDto){
        Build build = buildMapper.mapFromDto(buildDto);

        Build buildUpdated = buildService.updateBuild(buildId, build);
        BuildDto buildDtoUpdated = buildMapper.mapToDto(buildUpdated);
        return ResponseEntity.ok(buildDtoUpdated);
    }
}
