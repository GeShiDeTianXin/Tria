package com.tria.api.controller;

import com.custom.common.result.Result;
import com.tria.service.biz.FileStorageService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@AllArgsConstructor
@RequestMapping("/api/client/file")
public class FileController {

    private final FileStorageService fileStorageService;

    @PostMapping("/upload")
    public Result<String> upload(@RequestParam("file") MultipartFile file,
                                 @RequestParam(defaultValue = "common") String businessType) {
        String url = fileStorageService.upload(file, businessType);
        return Result.success(url);
    }
}