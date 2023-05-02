package kr.hs.gbsw.database.mapper;

import kr.hs.gbsw.database.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {

    public User readUser(@Param("userIdx") int userIdx);

}
