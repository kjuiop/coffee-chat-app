package io.gig.coffeechat.service.api.dto.follow;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * @author : JAKE
 * @date : 2022/11/19
 */
@Mapper(
        componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface FollowDtoMapper {

    FollowDto.Response of(Boolean isOk);
}
