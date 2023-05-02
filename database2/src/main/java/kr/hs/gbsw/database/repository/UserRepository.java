package kr.hs.gbsw.database.repository;

import kr.hs.gbsw.database.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    public Page<User> findByUserNameLike(String userName, Pageable pageable);

    public Optional<User> findByEmail(String email);

    @Query(value = "SELECT * FROM user WHERE email = :email ",
            nativeQuery = true)
    public Optional<User> getUserByEmail(String email);


    @Query(value = "SELECT u FROM User u WHERE u.email = :email")
    public Optional<User> getUserByEmail2(String email);

    //public List<User> getListByPhoneNumberLike1(String phoneNumber);

    //public List<User> getListByPhoneNumberLike2(String phoneNumber);

}
