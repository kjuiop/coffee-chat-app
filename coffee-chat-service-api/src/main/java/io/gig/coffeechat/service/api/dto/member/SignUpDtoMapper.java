package io.gig.coffeechat.service.api.dto.member;

import io.gig.coffeechat.domain.member.MemberCommand;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * @author : JAKE
 * @date : 2022/11/09
 */
@Mapper(
        componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface SignUpDtoMapper {

    MemberCommand.SignUp of(SignUpDto.SignUp request);

    SignUpDto.SignUpResponse of(String signUpToken);
}
