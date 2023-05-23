package kr.hs.gbsw.spring.sec.service;

import kr.hs.gbsw.spring.sec.domain.Member;
import kr.hs.gbsw.spring.sec.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service(value = "memberService")
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Member addMember(Member member) {
        String encryptedPassword =
                passwordEncoder.encode(member.getPassword());
        member.setPassword(encryptedPassword);

        memberRepository.save(member);

        return memberRepository.findById(member.getUserIdx())
                .orElseThrow();
    }

}
