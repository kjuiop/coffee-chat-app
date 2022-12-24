package io.gig.coffeechat.domain.member.mentee;

/**
 * @author : JAKE
 * @date : 2022/12/24
 */
public interface MenteeService {

    boolean changeSchoolName(String uuid, MenteeCommand.ChangeSchoolName request);

}
