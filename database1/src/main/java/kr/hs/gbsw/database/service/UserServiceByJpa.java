package kr.hs.gbsw.database.service;

import kr.hs.gbsw.database.entity.User;
import kr.hs.gbsw.database.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service(value = "userService")
public class UserServiceByJpa implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public User getUser(int userIdx) {
        Optional<User> optional = userRepository.findById(userIdx);
        return optional.orElseThrow();

        /*if (optional.isPresent()) {
            return optional.get();
        } else {
            throw new IllegalArgumentException();
        }*/
    }
}
