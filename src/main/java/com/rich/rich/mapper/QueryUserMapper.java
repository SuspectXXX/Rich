package com.rich.rich.mapper;

import com.rich.rich.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface QueryUserMapper {

    @Select("select * from qy_user where id=#{id}")
    public User queryUser(int id);
}
