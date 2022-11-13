package io.gig.coffeechat.domain.member;

import io.gig.coffeechat.domain.factory.MemberFixtureFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author : JAKE
 * @date : 2022/11/13
 */
public class MemberTest {

    @DisplayName("회원은 닉네임을 변경할 수 있다.")
    @Test
    public void testChangeNickname() {
        Member member = MemberFixtureFactory.create();
        String expected = "cat";

        member.changeNickname(expected);
        Assertions.assertEquals(expected, member.getNickname());
    }

    @DisplayName("회원의 닉네임은 10자를 초과할 수 없다.")
    @Test
    public void testNicknameMaxLength() {
        var member = MemberFixtureFactory.create();
        var overMaxLengthName = "arneg0shuaover10length";

        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> member.changeNickname(overMaxLengthName)
        );
    }
}
