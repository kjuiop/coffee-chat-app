package io.gig.coffeechat.domain.member.mentor;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

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
    private String schoolName;

    @Column(nullable = false)
    private Integer year;

    @Column(nullable = false)
    private String studentNo;

    @Column(nullable = false)
    private String major;

    public static MentorDetail createMentorDetail(MentorCommand.MentorDetailInfo info) {
        return MentorDetail.builder()
                .schoolName(info.getSchoolName())
                .year(info.getYear())
                .studentNo(info.getStudentNo())
                .major(info.getMajor())
                .build();
    }

}
