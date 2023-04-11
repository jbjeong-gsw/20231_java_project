package kr.hs.gbsw.database.service;

import kr.hs.gbsw.database.entity.User;

public interface UserService {

    public void save(User user);

    public User getUser(int userIdx);

}
