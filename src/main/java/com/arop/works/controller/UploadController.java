package com.arop.works.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @author bo.fan
 * @date 2019-04-09
 */

@RequestMapping("upload")
@RestController
public class UploadController {

    @Value("${resources_path}")
    private String filePath;

    @Value("${upload.url}")
    private String url;

    @RequestMapping("file")
    public String uploadFile(MultipartFile file) throws IOException {
        if (file == null) {
            return "-1";
        }
        String name = file.getOriginalFilename();
        if (StringUtils.isEmpty(name)) {
            return "-2";
        }
        if (new File(filePath + name).exists()) {
            return "-3";
        }
        File newFile = new File(filePath + name);
        file.transferTo(newFile);
        return url + name;
    }
}
