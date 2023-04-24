package kr.hs.gbsw.database.service;

import kr.hs.gbsw.database.entity.User;
import kr.hs.gbsw.database.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
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
    }

    @Override
    public List<User> getList() {
        return userRepository.findAll(Sort.by(Sort.Direction.ASC , "userName"));
    }

    @Override
    public Page<User> getPagingList(int pageNumber) {
        return userRepository.findAll(PageRequest.of(pageNumber, 3,
                Sort.by(Sort.Direction.ASC , "userName")));
    }
}
