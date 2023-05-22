package kr.hs.gbsw.spring.sec.domain;

import kr.hs.gbsw.spring.sec.service.MyUserDetailsService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collection;
import java.util.LinkedList;

public class MyUserDetails implements UserDetails {

    private PasswordEncoder passwordEncoder;

    private String username;

    private String password;

    private int grade;

    public MyUserDetails(PasswordEncoder encoder, String username, String password,
                         int grade) {
        this.passwordEncoder = encoder;
        this.username = username;
        this.password = password;
        this.grade = grade;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<SimpleGrantedAuthority> result = new LinkedList<>();

        if (grade >= 1) {
            result.add(new SimpleGrantedAuthority("ROLE_USER"));
        }

        if (grade >= 3) {
            result.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        }

        if (grade >= 5) {
            result.add(new SimpleGrantedAuthority("ROLE_SUPERVISOR"));
        }

        return result;
    }

    @Override
    public String getPassword() {
        return passwordEncoder.encode(password);
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
