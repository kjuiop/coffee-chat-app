package io.gig.coffeechat.domain.member.parent;

/**
 * @author : JAKE
 * @date : 2022/12/24
 */
public interface ParentService {

    boolean changeHighSchool(String uuid, ParentCommand.ChangeHighSchool request);

    boolean changeYear(String uuid, ParentCommand.ChangeYear request);
}
