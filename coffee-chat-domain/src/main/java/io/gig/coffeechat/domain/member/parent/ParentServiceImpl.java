package io.gig.coffeechat.domain.member.parent;

import io.gig.coffeechat.domain.member.Member;
import io.gig.coffeechat.domain.member.MemberReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author : JAKE
 * @date : 2022/12/24
 */
@Service
@RequiredArgsConstructor
public class ParentServiceImpl implements ParentService {

    private final MemberReader memberReader;
    private final ParentStore parentStore;

    @Override
    @Transactional
    public boolean changeSchoolName(String uuid, ParentCommand.ChangeSchoolName request) {

        Member findMember = memberReader.getMember(uuid);
        ParentDetail findParentDetail = findMember.getParentDetail();
        findParentDetail.changeSchoolName(request.getSchoolName());
        parentStore.store(findParentDetail);

        return true;
    }

    @Override
    @Transactional
    public boolean changeYear(String uuid, ParentCommand.ChangeYear request) {

        Member findMember = memberReader.getMember(uuid);
        ParentDetail findParentDetail = findMember.getParentDetail();
        findParentDetail.changeYear(request.getYear());
        parentStore.store(findParentDetail);

        return true;
    }
}
