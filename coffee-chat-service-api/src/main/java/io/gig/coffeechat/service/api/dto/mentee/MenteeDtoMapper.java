package io.gig.coffeechat.service.api.dto.mentee;

import io.gig.coffeechat.domain.member.mentee.MenteeCommand;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * @author : JAKE
 * @date : 2022/12/24
 */
@Mapper(
        componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface MenteeDtoMapper {

    MenteeCommand.ChangeSchoolName of(MenteeDto.ChangeSchoolNameRequest request);

    MenteeDto.Response of(Boolean isOk);

}
