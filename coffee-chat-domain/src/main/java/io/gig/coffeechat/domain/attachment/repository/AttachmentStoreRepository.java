package io.gig.coffeechat.domain.attachment.repository;

import io.gig.coffeechat.domain.attachment.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author : JAKE
 * @date : 2022/12/18
 */
@Repository
public interface AttachmentStoreRepository extends JpaRepository<Attachment, Long> {
}
