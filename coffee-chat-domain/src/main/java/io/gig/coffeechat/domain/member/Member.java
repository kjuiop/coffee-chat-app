package io.gig.coffeechat.domain.member;

import io.gig.coffeechat.domain.common.BaseTimeEntity;
import io.gig.coffeechat.domain.common.YnType;
import io.gig.coffeechat.domain.member.mentee.MenteeCommand;
import io.gig.coffeechat.domain.member.mentee.MenteeDetail;
import io.gig.coffeechat.domain.member.mentor.MentorCommand;
import io.gig.coffeechat.domain.member.mentor.MentorDetail;
import io.gig.coffeechat.domain.member.parent.ParentCommand;
import io.gig.coffeechat.domain.member.parent.ParentDetail;
import io.gig.coffeechat.domain.member.types.GenderType;
import io.gig.coffeechat.domain.member.types.UsageAuthorityType;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static javax.persistence.FetchType.LAZY;

/**
 * @author : JAKE
 * @date : 2022/11/09
 */
@Getter
@SuperBuilder
@Entity
@Table(name = "members")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class Member extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    private String uuid;

    private String email;

    private String nickname;

    private LocalDate birth;

    @Enumerated(EnumType.STRING)
    private GenderType gender;

    @Enumerated(EnumType.STRING)
    private UsageAuthorityType usageAuthority;

    @Builder.Default
    @Column(columnDefinition = "varchar(2) default 'N'", nullable = false)
    @Enumerated(EnumType.STRING)
    private YnType deleteYn = YnType.N;

    private LocalDateTime joinedAt;

    private LocalDateTime lastLoginAt;

    private LocalDateTime emailValidatedAt;

    private LocalDateTime policyAgreementAt;

    private LocalDateTime privacyAgreementAt;

    private LocalDateTime marketingAgreementAt;

    @ManyToOne(fetch = LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "mentee_id")
    private MenteeDetail menteeDetail;

    @ManyToOne(fetch = LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "mentor_id")
    private MentorDetail mentorDetail;

    @ManyToOne(fetch = LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "parent_id")
    private ParentDetail parentDetail;

    public static Member MenteeSignUp(String uuid, MenteeCommand.SignUp signUp, MenteeDetail menteeDetail) {
        LocalDateTime current = LocalDateTime.now();
        return Member.builder()
                .uuid(uuid)
                .email(signUp.getEmail())
                .nickname(signUp.getNickname())
                .birth(signUp.getBirth())
                .gender(signUp.getGender())
                .usageAuthority(UsageAuthorityType.MENTEE)
                .joinedAt(current)
                .policyAgreementAt(current)
                .privacyAgreementAt(current)
                .menteeDetail(menteeDetail)
                .build();
    }

    public static Member MentorSignUp(String uuid, MentorCommand.SignUp signUp, MentorDetail mentorDetail) {
        LocalDateTime current = LocalDateTime.now();
        return Member.builder()
                .uuid(uuid)
                .email(signUp.getEmail())
                .nickname(signUp.getNickname())
                .birth(signUp.getBirth())
                .gender(signUp.getGender())
                .usageAuthority(signUp.getUsageAuthority())
                .joinedAt(current)
                .policyAgreementAt(current)
                .privacyAgreementAt(current)
                .mentorDetail(mentorDetail)
                .build();
    }

    public static Member ParentSignUp(String uuid, ParentCommand.SignUp signUp, ParentDetail parentDetail) {
        LocalDateTime current = LocalDateTime.now();
        return Member.builder()
                .uuid(uuid)
                .email(signUp.getEmail())
                .nickname(signUp.getNickname())
                .birth(signUp.getBirth())
                .gender(signUp.getGender())
                .usageAuthority(signUp.getUsageAuthority())
                .joinedAt(current)
                .policyAgreementAt(current)
                .privacyAgreementAt(current)
                .parentDetail(parentDetail)
                .build();
    }
}
