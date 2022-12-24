package io.gig.coffeechat.domain.member.parent;

import io.gig.coffeechat.domain.member.MemberCommand;
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
@Table(name = "parent_detail")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class ParentDetail {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "parent_id")
    private Long id;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private StudentType studentType;

    @Column(nullable = false)
    private Integer year;

    @Column(nullable = false)
    private String schoolName;

    private static Long YEAR_MAX_VALUE = 3L;

    public static ParentDetail createParentDetail(MemberCommand.ParentDetailInfo info) {
        return ParentDetail.builder()
                .studentType(info.getStudentType())
                .year(info.getYear())
                .schoolName(info.getSchoolName())
                .build();
    }

    public void changeSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public void changeYear(Integer year) {
        this.year = year;
    }

    public void validateYear(Integer year) {
        Assert.isTrue(year <= YEAR_MAX_VALUE, "자녀의 학년 정보를 다시 입력해주세요.");
    }


}
