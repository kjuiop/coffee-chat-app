package io.gig.coffeechat.domain.member.parent;

import io.gig.coffeechat.domain.member.types.StudentType;
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
@Table(name = "parent_detail")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class ParentDetail {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "parent_id")
    private Long id;

    @Enumerated(EnumType.STRING)
    private StudentType studentType;

    private Integer year;

    private String schoolName;

    public static ParentDetail createParentDetail(ParentCommand.ParentDetailInfo info) {
        return ParentDetail.builder()
                .studentType(info.getStudentType())
                .year(info.getYear())
                .schoolName(info.getSchoolName())
                .build();
    }

}