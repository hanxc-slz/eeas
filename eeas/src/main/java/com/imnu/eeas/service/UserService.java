package com.imnu.eeas.service;

import com.imnu.eeas.pojo.User;

import java.util.List;

/**
 * 用户   业务层
 * @Author hxc
 * @Date 2019/11/29 18:20
 */
public interface UserService {
    // 根据ID查询
    User findUserById(Integer uid);

    // 批量查询
    List<User> findUsersById(List<Integer> uid);

    // 新增用户
    Integer createNewUser(User user);

    //根据id删除
    void deleteUserById(Integer uid);

    //批量删除
    void deleteUsersById(List<Integer> uid);

    //修改
    void updateUserById(User user);
}
