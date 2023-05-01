package kr.hs.gbsw.database.repository;

import kr.hs.gbsw.database.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository
        extends JpaRepository<User, Integer> {

    public Optional<User> findByEmail(String email);

    public List<User> findByUserName(String userName);

    public Page<User> findByUserNameLike(String userName, Pageable pageable);

    @Query(value = "SELECT * FROM user WHERE user_name LIKE CONCAT('%', :abcd, '%') ", nativeQuery = true)
    public List<User> getList(String abcd);

    @Query(value = "SELECT u FROM User u WHERE u.userName LIKE %:userName% ")
    public List<User> getListByJPQL(String userName);

}
