package io.gig.coffeechat.domain.member.mentee;

import io.gig.coffeechat.domain.member.types.StudentType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.util.Assert;

import javax.persistence.*;

/**
 * @author : JAKE
 * @date : 2022/11/09
 */
@Getter
@SuperBuilder
@Entity
@Table(name = "mentee_detail")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class MenteeDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mentee_id")
    private Long id;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private StudentType studentType;

    @Column(nullable = false)
    private Integer year;

    @Column(nullable = false)
    private String schoolName;

    private static Long YEAR_MAX_VALUE = 3L;

    public static MenteeDetail createMenteeDetail(MenteeCommand.MenteeDetailInfo info) {
        return MenteeDetail.builder()
                .studentType(info.getStudentType())
                .year(info.getYear())
                .schoolName(info.getSchoolName())
                .build();
    }

    public void validateYear(Integer year) {
        Assert.isTrue(year <= YEAR_MAX_VALUE, "학년 정보를 다시 입력해주세요.");
    }
}