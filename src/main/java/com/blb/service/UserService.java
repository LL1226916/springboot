package com.blb.service;

import com.blb.dao.UserMapper;
import com.blb.pojo.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public UserInfo queryUserByid(Long i) {
        return userMapper.selectByPrimaryKey(i);
    }

    @Transactional
    public void deleteById(Long id) {
        userMapper.deleteByPrimaryKey(id);
    }

    public List<UserInfo> queryAllUser() {
        return userMapper.selectAll();
    }
}
