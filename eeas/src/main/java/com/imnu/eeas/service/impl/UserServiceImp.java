package com.imnu.eeas.service.impl;

import com.imnu.eeas.dao.UserMapper;
import com.imnu.eeas.pojo.User;
import com.imnu.eeas.pojo.exemple.UserExample;
import com.imnu.eeas.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @Author hxc
 * @Date 2019/11/29 18:29
 */
@Service
public class UserServiceImp implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User findUserById(Integer uid) {
        return userMapper.selectByPrimaryKey(uid);
    }

    @Override
    public List<User> findUsersById(List<Integer> uid) {
        UserExample example = new UserExample();
        example.createCriteria().andIdIn(uid);
        return userMapper.selectByExample(example);
    }

    @Override
    public Integer createNewUser(User user) {
        User u = new User();
        BeanUtils.copyProperties(user,u);
        userMapper.insertSelective(u);
        return u.getId();
    }

    @Override
    public void deleteUserById(Integer uid) {
        userMapper.deleteByPrimaryKey(uid);
    }

    @Override
    public void deleteUsersById(List<Integer> uid) {
        if (CollectionUtils.isEmpty(uid))
            return;
        UserExample example = new UserExample();
        example.createCriteria().andIdIn(uid);
        userMapper.deleteByExample(example);
    }

    @Override
    public void updateUserById(User user) {
        User u = new User();
        BeanUtils.copyProperties(user,u);
        int result = userMapper.updateByPrimaryKeySelective(u);
        if (result == 0)
            throw new RuntimeException("更新失败，更新结果数为0");
    }
}
