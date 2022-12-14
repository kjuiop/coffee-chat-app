package io.gig.coffeechat.domain.attachment;

import io.gig.coffeechat.domain.attachment.types.FileType;
import io.gig.coffeechat.domain.attachment.utils.FileManager;
import io.gig.coffeechat.domain.attachment.utils.S3UploadUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

/**
 * @author : JAKE
 * @date : 2022/12/13
 */
@Service
@RequiredArgsConstructor
public class ImageUploadService implements UploadService {

    private final S3UploadUtils s3UploadUtils;
    private final FileManager fileManager;

    @Override
    public AttachmentInfo.Main upload(AttachmentCommand.Upload request) {

        MultipartFile mf = request.getMultipartFile();
        String foldDlv = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMM"));
        String filePath = request.getUsageType().getType() + File.separator +  request.getFileType() + File.separator + foldDlv;

        S3UploadUtils.createBucketFolder();

        long time = System.currentTimeMillis();
        String originalFilename = mf.getOriginalFilename();
        String saveFileName = String.format("%d_%s", time, originalFilename.replaceAll(" ", ""));

        File uploadFile = null;
        try {
            Optional<File> uploadFileOpt = fileManager.convertMultipartFileToFile(mf);
            if (uploadFileOpt.isEmpty()) {
                throw new Exception("파일변환에 실패했습니다.");
            }
            uploadFile = uploadFileOpt.get();
            String saveFilePath = s3UploadUtils.upload(uploadFile, filePath, saveFileName);

            return AttachmentInfo.Main.builder()
                    .fileType(FileType.Image)
                    .usageType(request.getUsageType())
                    .uuid(request.getUuid())
                    .originalFilename(originalFilename)
                    .savedFilename(saveFileName)
                    .fullPath(saveFilePath)
                    .build();
        } catch (Exception e) {
            e.printStackTrace();
        }  finally {
            if (uploadFile != null) {
                uploadFile.delete();
            }
        }

        return null;
    }
}
