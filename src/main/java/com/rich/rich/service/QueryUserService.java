package com.rich.rich.service;

import com.rich.rich.bean.User;
import com.rich.rich.mapper.QueryUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QueryUserService {
    @Autowired
    QueryUserMapper queryUserMapper;

    public User queryUser(int id) {
        User user = queryUserMapper.queryUser(id);
        return user;
    }
}
