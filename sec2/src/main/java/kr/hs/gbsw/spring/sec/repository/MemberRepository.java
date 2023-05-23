package kr.hs.gbsw.spring.sec.repository;

import kr.hs.gbsw.spring.sec.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository
        extends JpaRepository<Member, Integer> {

    public Optional<Member> findByEmail(String email);
}
