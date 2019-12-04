package com.imnu.eeas.service;

import com.imnu.eeas.pojo.UserRole;

import java.util.List;

/**
 * 管理员  业务层实现
 * @Author hxc
 * @Date 2019/11/29 18:36
 */
public interface UserRoleService {
    // 根据ID查询
    UserRole findUserRoleById(Integer id);

    // 批量查询
    List<UserRole> findUserRolesById(List<Integer> id);

    // 新增用户与角色的对应
    Integer createNewUserRolefindById(UserRole userRole);

    //根据id删除
    void deleteURById(Integer id);

    //批量删除
    void deleteURsById(List<Integer> ids);

    //修改
    void updateURById(UserRole userRole);
}
