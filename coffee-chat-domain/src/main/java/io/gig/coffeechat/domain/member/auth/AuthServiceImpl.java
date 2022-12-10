package io.gig.coffeechat.domain.member.auth;

import io.gig.coffeechat.domain.exception.NotFoundException;
import io.gig.coffeechat.domain.member.Member;
import io.gig.coffeechat.domain.member.repository.MemberQueryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.nio.file.AccessDeniedException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author : JAKE
 * @date : 2022/11/16
 */
@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements UserDetailsService {

    private final MemberQueryRepository memberQueryRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String uuid) throws UsernameNotFoundException {

        Optional<Member> findMember = memberQueryRepository.findByUuid(uuid);
        if (findMember.isEmpty()) {
            throw new NotFoundException("존재하지 않는 회원입니다.");
        }

        Member member = findMember.get();

        Set<GrantedAuthority> authorities = member.getMemberRoles()
                .stream()
                .map(r -> new SimpleGrantedAuthority(r.getRole().getName()))
                .collect(Collectors.toSet());

        boolean loginEnabled = true;
        boolean accountNonExpired = true;
        boolean credentialNonExpired = true;
        boolean accountNonLocked = true;

        return new LoginUser(member.getEmail(), "", loginEnabled, accountNonExpired, credentialNonExpired, accountNonLocked, authorities, member);
    }

    @Transactional
    public void validateLoginUser(String uid, String email) throws AccessDeniedException {
        Optional<Member> findMember = memberQueryRepository.findByUuid(uid);
        if (findMember.isEmpty()) {
            throw new NotFoundException("존재하지 않는 회원입니다.");
        }

        Member member = findMember.get();

        if (member.getEmail().equals(email)) {
            return;
        }

        throw new AccessDeniedException("로그인한 계정이 일치하지 않습니다.");
    }
}
