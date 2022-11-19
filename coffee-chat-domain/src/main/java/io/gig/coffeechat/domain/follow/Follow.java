package io.gig.coffeechat.domain.follow;

import io.gig.coffeechat.domain.common.BaseTimeEntity;
import io.gig.coffeechat.domain.member.MemberInfo;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

/**
 * @author : JAKE
 * @date : 2022/11/19
 */
@Entity
@Getter
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class Follow extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "follow_id")
    private Long id;

    private Long fromMemberId;

    private Long toMemberId;

    public static Follow CreateFollow(MemberInfo.Main fromMember, MemberInfo.Main toMember) {
        return Follow.builder()
                .fromMemberId(fromMember.getMemberId())
                .toMemberId(toMember.getMemberId())
                .build();
    }

}
