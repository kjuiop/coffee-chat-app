package io.gig.coffeechat.service.api.dto.parent;

import io.gig.coffeechat.domain.member.parent.ParentCommand;
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
public interface ParentDtoMapper {

    ParentCommand.ChangeSchoolName of(ParentDto.ChangeSchoolNameRequest request);

    ParentCommand.ChangeYear of(ParentDto.ChangeYearRequest request);

    ParentDto.Response of(Boolean isOk);

}
