package io.gig.coffeechat.domain.member.parent.repository;

import io.gig.coffeechat.domain.member.parent.ParentCommand;
import io.gig.coffeechat.domain.member.parent.ParentDetail;
import io.gig.coffeechat.domain.member.parent.ParentService;
import io.gig.coffeechat.domain.member.parent.ParentStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author : JAKE
 * @date : 2022/12/24
 */
@Service
@RequiredArgsConstructor
public class ParentStoreImpl implements ParentStore {

    private final ParentStoreRepository parentStoreRepository;

    @Override
    public ParentDetail store(ParentDetail parentDetail) {
        return parentStoreRepository.save(parentDetail);
    }
}
