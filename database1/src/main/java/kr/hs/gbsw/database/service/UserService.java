package kr.hs.gbsw.database.service;

import kr.hs.gbsw.database.entity.User;
import org.springframework.data.domain.Page;

import java.util.List;

public interface UserService {

    public void save(User user);

    public User getUser(int userIdx);

    public List<User> getList();

    public Page<User> getPagingList(int pageNumber);

}
