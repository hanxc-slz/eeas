package com.imnu.eeas.service;

import com.imnu.eeas.pojo.Role;


import java.util.List;

/**
 * @Author hxc
 * @Date 2019/11/29 18:36
 */
public interface RoleService {

    // 根据ID查询
    Role findRoleById(Integer id);

    // 批量查询
    List<Role> findRolesById(List<Integer> ids);

    // 新增角色
    Integer createNewRole(Role role);

    //根据id删除
    void deleteRoleById(Integer id);

    //批量删除
    void deleteRolesById(List<Integer> ids);

    //修改
    void updateRoleById(Role role);
}
