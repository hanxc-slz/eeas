package com.imnu.eeas.service;

import com.imnu.eeas.pojo.AdminUser;

import java.util.List;

/**
 * @Author hxc
 * @Date 2019/11/29 18:35
 */
public interface AdminUserService {

    //登录
    AdminUser login(AdminUser adminUser);

    // 根据ID查询
    AdminUser findAdminUserById(Integer id);

    // 批量查询
    List<AdminUser> findAdminUsersById(List<Integer> ids);

    // 新增用户
    Integer createNewAdminUser(AdminUser adminUser);

    //根据id删除
    void deleteAdminUserById(Integer id);

    //批量删除
    void deleteAdminUsersById(List<Integer> ids);

    //修改
    void updateAdminUserById(AdminUser adminUser);
}
