package com.tria.service.biz;

import org.springframework.web.multipart.MultipartFile;

/**
 * 文件上传接口
 */
public interface FileStorageService {
    /**
     * 上传文件，返回可访问的URL
     */
    String upload(MultipartFile file, String businessType);
}
