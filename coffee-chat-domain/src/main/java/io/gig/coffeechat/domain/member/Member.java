package io.gig.coffeechat.domain.member;

import io.gig.coffeechat.domain.common.BaseTimeEntity;
import io.gig.coffeechat.domain.common.YnType;
import io.gig.coffeechat.domain.member.memberRole.MemberRole;
import io.gig.coffeechat.domain.member.mentee.MenteeDetail;
import io.gig.coffeechat.domain.member.mentor.MentorDetail;
import io.gig.coffeechat.domain.member.parent.ParentDetail;
import io.gig.coffeechat.domain.member.types.GenderType;
import io.gig.coffeechat.domain.member.types.UsageAuthorityType;
import io.gig.coffeechat.domain.member.types.UserStatusType;
import io.gig.coffeechat.domain.role.Role;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.util.Assert;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

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

    @Column(nullable = false)
    private String uuid;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String nickname;

    @Column(nullable = false)
    private LocalDate birth;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private GenderType gender;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private UsageAuthorityType usageAuthority;

    @Column(length = 1000)
    private String profileImageUrl;

    private String refreshToken;

    @Builder.Default
    @Column(columnDefinition = "varchar(2) default 'N'", nullable = false)
    @Enumerated(EnumType.STRING)
    private YnType disableYn = YnType.N;

    @Builder.Default
    @Column(columnDefinition = "varchar(2) default 'N'", nullable = false)
    @Enumerated(EnumType.STRING)
    private YnType deleteYn = YnType.N;

    @Builder.Default
    @Column(nullable = false, length = 20)
    @Enumerated(EnumType.STRING)
    private UserStatusType status = UserStatusType.PENDING;

    private LocalDateTime joinedAt;

    private LocalDateTime lastLoginAt;

    private LocalDateTime emailValidatedAt;

    private LocalDateTime policyAgreementAt;

    private LocalDateTime privacyAgreementAt;

    private LocalDateTime marketingAgreementAt;

    @OneToOne(fetch = LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "mentee_id")
    private MenteeDetail menteeDetail;

    @OneToOne(fetch = LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "mentor_id")
    private MentorDetail mentorDetail;

    @OneToOne(fetch = LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "parent_id")
    private ParentDetail parentDetail;

    @Builder.Default
    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true)
    private Set<MemberRole> memberRoles = new HashSet<>();

    final private static Long NAME_MAX_LENGTH = 12L;

    public static Member MenteeSignUp(String uuid, MemberCommand.SignUp signUp, MenteeDetail menteeDetail) {
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
                .marketingAgreementAt(signUp.getMarketingAgreeYn() == YnType.Y ? current : null)
                .menteeDetail(menteeDetail)
                .build();
    }

    public static Member MentorSignUp(String uuid, MemberCommand.SignUp signUp, MentorDetail mentorDetail) {
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
                .marketingAgreementAt(signUp.getMarketingAgreeYn() == YnType.Y ? current : null)
                .mentorDetail(mentorDetail)
                .build();
    }

    public static Member ParentSignUp(String uuid, MemberCommand.SignUp signUp, ParentDetail parentDetail) {
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
                .marketingAgreementAt(signUp.getMarketingAgreeYn() == YnType.Y ? current : null)
                .parentDetail(parentDetail)
                .build();
    }

    public void isValidEmail() {
        this.emailValidatedAt = LocalDateTime.now();
    }

    public void changeNickname(String nickname) {
        validateNickname(nickname);
        this.nickname = nickname;
    }

    public void changeProfileImage(String profileImageUrl) {
        this.profileImageUrl = profileImageUrl;
    }

    public void changeMarketingApprove(String marketingApproveYn) {
        if (YnType.Y == YnType.valueOf(marketingApproveYn)) {
            LocalDateTime current = LocalDateTime.now();
            this.marketingAgreementAt = current;
            return;
        }

        this.marketingAgreementAt = null;
    }

    public void login(String refreshToken) {
        LocalDateTime current = LocalDateTime.now();
        this.lastLoginAt = current;
        this.refreshToken = refreshToken;
    }

    public void addRole(MemberRole role) {
        this.memberRoles.add(role);
    }

    public void validateNickname(String nickname) {
        Assert.isTrue(nickname.length() <= NAME_MAX_LENGTH, "닉네임의 최대 길이를 초과했습니다.");
    }
}
