package com.hachathon.farmmate.api.service;

import com.amazonaws.services.kms.model.CloudHsmClusterInUseException;
import com.hachathon.farmmate.config.s3.S3UploadUtil;
import com.hachathon.farmmate.exception.CustomException;
import com.hachathon.farmmate.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class S3Service {

    private final S3UploadUtil s3UploadUtil;

    public String uploadImage(MultipartFile image)  {
        String imageUrl = "";
        if (image != null && !image.isEmpty()) {
            try {
                imageUrl = s3UploadUtil.upload(image);
            } catch (Exception e) {
                throw new CustomException(ErrorCode.FAIL_IMAGE_UPLOAD);
            }
        }
        return imageUrl;
    }
}
