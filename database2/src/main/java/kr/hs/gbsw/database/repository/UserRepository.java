package kr.hs.gbsw.database.repository;

import kr.hs.gbsw.database.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    public Page<User> findByUserNameLike(String userName, Pageable pageable);

}
