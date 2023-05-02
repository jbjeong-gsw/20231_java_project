package kr.hs.gbsw.database.service;

import kr.hs.gbsw.database.entity.User;
import kr.hs.gbsw.database.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "userService")
public class UserServiceByMybatis implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public void save(User user) {

    }

    @Override
    public User getUser(int userIdx) {
        User user = userMapper.getUser(userIdx);
        if (user == null) {
            throw new IllegalArgumentException();
        } else {
            return user;
        }
    }

    @Override
    public List<User> getList() {
        return null;
    }

    @Override
    public Page<User> getPagingList(int pageNumber) {
        return null;
    }

    @Override
    public Page<User> getSearchList(String search, int pageNumber) {
        return null;
    }
}
