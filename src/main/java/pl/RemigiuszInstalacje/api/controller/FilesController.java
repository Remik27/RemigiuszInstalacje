package pl.RemigiuszInstalacje.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(FilesController.FILES_API)
public class FilesController {

    public static final String FILES_API = "/files";

    public static final String GET_FILES = "/get-files";
    public static final String SAVE_FILES = "/save-files";
    public static final String DELETE_FILES = "/delete-files";
    //todo write implementation
}
