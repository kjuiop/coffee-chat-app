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
}
