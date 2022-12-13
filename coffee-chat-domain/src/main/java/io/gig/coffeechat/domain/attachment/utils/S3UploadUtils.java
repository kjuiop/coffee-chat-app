package io.gig.coffeechat.domain.attachment.utils;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.File;

/**
 * @author : JAKE
 * @date : 2022/12/13
 */
@Component
@RequiredArgsConstructor
public class S3UploadUtils {

    private final String bucketFolder = "image/";

    public static void createBucketFolder() {

    }


    public String upload(File uploadFile, String filePath, String saveFileName) {
        return null;
    }
}
