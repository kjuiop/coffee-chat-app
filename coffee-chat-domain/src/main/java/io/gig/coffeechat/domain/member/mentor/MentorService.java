package io.gig.coffeechat.domain.member.mentor;

/**
 * @author : JAKE
 * @date : 2022/12/22
 */
public interface MentorService {

    boolean changeSchoolName(String uuid, MentorCommand.ChangeSchoolName request);

    boolean changeYear(String uuid, MentorCommand.ChangeYear request);
}
