package io.gig.coffeechat.domain.member.parent;

/**
 * @author : JAKE
 * @date : 2022/12/24
 */
public interface ParentService {

    boolean changeSchoolName(String uuid, ParentCommand.ChangeSchoolName request);

    boolean changeYear(String uuid, ParentCommand.ChangeYear request);
}
