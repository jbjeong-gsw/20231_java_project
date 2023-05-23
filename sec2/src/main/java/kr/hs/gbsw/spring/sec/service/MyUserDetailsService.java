package kr.hs.gbsw.spring.sec.service;

import kr.hs.gbsw.spring.sec.domain.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service(value = "userDetailsService")
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        if ("임동주".equals(username)) {
            return new MyUserDetails(passwordEncoder, "임동주",
                    "1111", 1);
        } else {
            throw new UsernameNotFoundException(username);
        }
    }
}