package io.gig.coffeechat.domain.member.auth;

import io.gig.coffeechat.domain.member.Member;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;
import java.util.Map;

/**
 * @author : JAKE
 * @date : 2022/11/16
 */
@Getter
public class LoginUser extends User {

    private Member loginUser;

    @Setter
    private Map<String, Object> attributes;

    public LoginUser(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities, Member loginUser) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
        this.loginUser = loginUser;
    }

    public LoginUser(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities, Member loginUser, Map<String, Object> attributes) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
        this.loginUser = loginUser;
        this.attributes = attributes;
    }

    public LoginUser(String username, String password, Member loginUser, Collection<? extends GrantedAuthority> authorities, Map<String, Object> attributes) {
        super(username, password, authorities);
        this.loginUser = loginUser;
        this.attributes = attributes;
    }

}
