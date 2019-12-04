package com.imnu.eeas.service.impl;

import com.imnu.eeas.dao.RoleMapper;
import com.imnu.eeas.pojo.Role;
import com.imnu.eeas.pojo.exemple.RoleExample;
import com.imnu.eeas.service.RoleService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @Author hxc
 * @Date 2019/11/29 18:37
 */
@Service
public class RoleServiceImp implements RoleService {
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public Role findRoleById(Integer id) {
        return roleMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Role> findRolesById(List<Integer> ids) {
        RoleExample roleExample = new RoleExample();
        roleExample.createCriteria().andIdIn(ids);
        return roleMapper.selectByExample(roleExample);
    }

    @Override
    public Integer createNewRole(Role role) {
        Role rol = new Role();
        BeanUtils.copyProperties(role, rol);
        roleMapper.insertSelective(rol);
        return rol.getId();
    }

    @Override
    public void deleteRoleById(Integer id) {
        roleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void deleteRolesById(List<Integer> ids) {
        if(CollectionUtils.isEmpty(ids))
            return;
        RoleExample roleExample = new RoleExample();
        roleExample.createCriteria().andIdIn(ids);
        roleMapper.deleteByExample(roleExample);
    }

    @Override
    public void updateRoleById(Role role) {
        Role rol = new Role();
        BeanUtils.copyProperties(role, rol);
        int result = roleMapper.updateByPrimaryKeySelective(rol);
        if(result == 0)
            throw new RuntimeException("更新失败，更新结果数为0");
    }
}
