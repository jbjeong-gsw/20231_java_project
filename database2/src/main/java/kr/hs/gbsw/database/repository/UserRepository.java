package kr.hs.gbsw.database.repository;

import kr.hs.gbsw.database.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}
