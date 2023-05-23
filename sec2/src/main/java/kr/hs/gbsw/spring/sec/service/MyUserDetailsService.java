package kr.hs.gbsw.spring.sec.service;

import kr.hs.gbsw.spring.sec.domain.Member;
import kr.hs.gbsw.spring.sec.domain.MyUserDetails;
import kr.hs.gbsw.spring.sec.domain.SimpleUserDetails;
import kr.hs.gbsw.spring.sec.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service(value = "userDetailsService")
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        Optional<Member> optional = memberRepository.findByEmail(username);

        if (optional.isPresent()) {
            Member member = optional.get();
            UserDetails userDetails = new SimpleUserDetails(member);
            return userDetails;
        } else {
            throw new UsernameNotFoundException(username);
        }
    }
}
