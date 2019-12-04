package com.imnu.eeas.service.impl;

import com.imnu.eeas.dao.UserRoleMapper;
import com.imnu.eeas.pojo.UserRole;
import com.imnu.eeas.pojo.exemple.UserRoleExample;
import com.imnu.eeas.service.UserRoleService;
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
public class UserRoleServiceImp implements UserRoleService {
    @Autowired
    private UserRoleMapper userRoleMapper;
    @Override
    public UserRole findUserRoleById(Integer id) {
        return userRoleMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<UserRole> findUserRolesById(List<Integer> id) {
        UserRoleExample userRoleExample = new UserRoleExample();
        userRoleExample.createCriteria().andIdIn(id);
        return userRoleMapper.selectByExample(userRoleExample);
    }

    @Override
    public Integer createNewUserRolefindById(UserRole userRole) {
        UserRole uRole = new UserRole();
        BeanUtils.copyProperties(userRole, uRole);
        userRoleMapper.insertSelective(uRole);
        return uRole.getId();
    }

    @Override
    public void deleteURById(Integer id) {
        userRoleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void deleteURsById(List<Integer> ids) {
        if(CollectionUtils.isEmpty(ids))
            return;
        UserRoleExample userRoleExample = new UserRoleExample();
        userRoleExample.createCriteria().andIdIn(ids);
        userRoleMapper.deleteByExample(userRoleExample);
    }

    @Override
    public void updateURById(UserRole userRole) {
        UserRole uRole = new UserRole();
        BeanUtils.copyProperties(userRole, uRole);
        int result = userRoleMapper.updateByPrimaryKeySelective(uRole);
        if(result == 0)
            throw new RuntimeException("更新失败，更新结果数为0");
    }
}
