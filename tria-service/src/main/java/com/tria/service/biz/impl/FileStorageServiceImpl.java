package com.tria.service.biz.impl;

import com.tria.service.biz.FileStorageService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * 文件上传接口实现
 */
@Service
public class FileStorageServiceImpl implements FileStorageService {

    @Value("${custom.file.local-path}")
    private String localPath;       // 比如 D:/tria-uploads/

    @Value("${custom.file.local-domain}")
    private String localDomain;     // 比如 http://localhost:8081/uploads

    /**
     * 上传文件，返回可访问的URL
     *
     * @param file
     * @param businessType
     */
    @Override
    public String upload(MultipartFile file, String businessType) {
        try {
            String originalName = file.getOriginalFilename();
            String ext = originalName.substring(originalName.lastIndexOf("."));
            String fileName = UUID.randomUUID().toString().replace("-", "") + ext;

            // 按业务类型分文件夹，比如 avatar/xxx.jpg
            String dir = localPath + businessType + "/";
            File dirFile = new File(dir);
            if (!dirFile.exists()) {
                dirFile.mkdirs();
            }

            File dest = new File(dir + fileName);
            file.transferTo(dest);

            return localDomain + "/" + businessType + "/" + fileName;
        } catch (IOException e) {
            throw new RuntimeException("文件上传失败", e);
        }
    }
}
