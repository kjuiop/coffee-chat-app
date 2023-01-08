package io.gig.coffeechat.domain.member.mentor;

/**
 * @author : JAKE
 * @date : 2022/12/22
 */
public interface MentorService {

    boolean changeUniversity(String uuid, MentorCommand.ChangeUniversity request);

    boolean changeYear(String uuid, MentorCommand.ChangeYear request);
}
