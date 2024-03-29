package io.gig.coffeechat.service.api.dto.member;

import io.gig.coffeechat.domain.member.MemberCommand;
import io.gig.coffeechat.domain.member.MemberInfo;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

/**
 * @author : JAKE
 * @date : 2022/11/12
 */
@Mapper(
        componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface MemberDtoMapper {

    MemberDto.ValidateResponse of(Boolean isValid);

    MemberCommand.ChangeNickname of(MemberDto.ChangeNicknameRequest request);

    MemberCommand.ChangeProfileImage of(MemberDto.ChangeProfileImageRequest request);

    MemberCommand.ChangeMarketingApprove of(MemberDto.ChangeMarketingApproveRequest request);

    List<MemberDto.Main> of(List<MemberInfo.Main> members);

    MemberDto.TokenResponse of(MemberInfo.TokenInfo tokenInfo);

}
