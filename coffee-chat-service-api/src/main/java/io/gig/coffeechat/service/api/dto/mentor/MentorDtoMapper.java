package io.gig.coffeechat.service.api.dto.mentor;

import io.gig.coffeechat.domain.member.mentor.MentorCommand;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * @author : JAKE
 * @date : 2022/12/22
 */
@Mapper(
        componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface MentorDtoMapper {

    MentorCommand.ChangeSchoolName of(MentorDto.ChangeSchoolNameRequest request);

    MentorDto.Response of(Boolean isOk);
}
