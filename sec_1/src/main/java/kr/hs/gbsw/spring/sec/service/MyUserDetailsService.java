package kr.hs.gbsw.spring.sec.service;

import kr.hs.gbsw.spring.sec.domain.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service(value = "userDetailsService")
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        if ("이재성".equals(username)) {
            return new MyUserDetails(passwordEncoder,
                    "이재성", "1111");
        } else if ("김윤현".equals(username)) {
            return new MyUserDetails(passwordEncoder,
                    "김윤현", "1234");
        }

        return null;
    }
}
