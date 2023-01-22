package io.gig.coffeechat.domain.member.mentor;

import io.gig.coffeechat.domain.member.Member;
import io.gig.coffeechat.domain.member.MemberCommand;
import io.gig.coffeechat.domain.member.mentee.MenteeDetail;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Type;
import org.springframework.util.Assert;

import javax.persistence.*;
import java.security.InvalidParameterException;
import java.util.List;
import java.util.Map;

import static javax.persistence.FetchType.LAZY;

/**
 * @author : JAKE
 * @date : 2022/11/09
 */
@Getter
@SuperBuilder
@Entity
@Table(name = "mentor_detail")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class MentorDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mentor_id")
    private Long id;

    @Column(nullable = false)
    private String university;

    @Column(nullable = false)
    private String highSchool;

    @Column(nullable = false)
    private Integer year;

    @Column(nullable = false)
    private String studentNo;

    @Column(nullable = false)
    private String major;

    private String admission;

    @Column(length = 1000)
    private String introduction;

    @Column(length = 1000)
    private String experience;

    @OneToOne(mappedBy = "mentorDetail")
    private Member member;

    private static Long YEAR_MAX_VALUE = 4L;

    public static MentorDetail createMentorDetail(MemberCommand.MentorDetailInfo info) {
        return MentorDetail.builder()
                .university(info.getUniversity())
                .year(info.getYear())
                .studentNo(info.getStudentNo())
                .major(info.getMajor())
                .build();
    }

    public void changeUniversity(String university) {
        this.university = university;
    }

    public void changeHighSchool(String highSchool) {
        this.highSchool = highSchool;
    }

    public void changeYear(Integer year) {
        this.year = year;
    }

    public void validateYear(Integer year) {
        Assert.isTrue(year <= YEAR_MAX_VALUE, "학년 정보를 다시 입력해주세요.");
    }
}
