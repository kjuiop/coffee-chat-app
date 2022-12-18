package io.gig.coffeechat.domain.attachment;

import io.gig.coffeechat.domain.attachment.types.FileType;
import io.gig.coffeechat.domain.attachment.types.UsageType;
import io.gig.coffeechat.domain.common.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

/**
 * @author : JAKE
 * @date : 2022/12/14
 */
@Getter
@SuperBuilder
@Entity
@Table(name = "attachments")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class Attachment extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "attachment_id")
    private Long id;

    @Enumerated(value = EnumType.STRING)
    private FileType fileType;

    private String orgFilename;

    private String savedFilename;

    private String fullPath;

    private String uuid;

    @Enumerated(value = EnumType.STRING)
    private UsageType usageType;

    public static Attachment Of(UsageType usageType, FileType fileType, String uuid, String orgFilename, String savedFilename, String fullPath) {
        return Attachment.builder()
                .usageType(usageType)
                .fileType(fileType)
                .uuid(uuid)
                .orgFilename(orgFilename)
                .savedFilename(savedFilename)
                .fullPath(fullPath)
                .build();
    }

}
