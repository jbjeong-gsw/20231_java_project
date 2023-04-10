package kr.hs.gbsw.database.repository;

import kr.hs.gbsw.database.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository
        extends JpaRepository<User, Integer> {

    public Optional<User> findByEmail(String email);

    public List<User> findByUserName(String userName);

}
