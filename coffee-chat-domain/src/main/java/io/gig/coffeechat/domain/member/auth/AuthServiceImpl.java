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
    public UserDetails loadUserByUsername(String uuid) throws UsernameNotFoundException {

        Optional<Member> findMember = memberQueryRepository.findByUuid(uuid);
        if (findMember.isEmpty()) {
            throw new NotFoundException("존재하지 않는 회원입니다.");
        }

        Member member = findMember.get();

        List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
        roles.add(new SimpleGrantedAuthority("ROLE_USER"));

        boolean loginEnabled = true;
        boolean accountNonExpired = true;
        boolean credentialNonExpired = true;
        boolean accountNonLocked = true;

        return new LoginUser(member.getEmail(), "", loginEnabled, accountNonExpired, credentialNonExpired, accountNonLocked, roles, member);
    }
}
