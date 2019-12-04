package com.imnu.eeas.service.impl;

import com.imnu.eeas.dao.AdminUserMapper;
import com.imnu.eeas.pojo.AdminUser;
import com.imnu.eeas.pojo.exemple.AdminUserExample;
import com.imnu.eeas.service.AdminUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @Author hxc
 * @Date 2019/11/29 18:36
 */
@Service
public class AdminUserServiceImp implements AdminUserService {
    @Autowired
    private AdminUserMapper adminUserMapper;

    @Override
    public AdminUser login(AdminUser adminUser) {
        AdminUserExample example = new AdminUserExample();
        example.createCriteria().andNameEqualTo(adminUser.getName()).andPasswordEqualTo(adminUser.getPassword());
        List<AdminUser> list = adminUserMapper.selectByExample(example);
        return list==null?null:list.get(0);
    }

    @Override
    public AdminUser findAdminUserById(Integer id) {
        return adminUserMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<AdminUser> findAdminUsersById(List<Integer> ids) {
        AdminUserExample adminUserExample = new AdminUserExample();
        adminUserExample.createCriteria().andAIdIn(ids);
        return adminUserMapper.selectByExample(adminUserExample);
    }

    @Override
    public Integer createNewAdminUser(AdminUser adminUser) {
        AdminUser aUser = new AdminUser();
        BeanUtils.copyProperties(adminUser, aUser);
        adminUserMapper.insertSelective(aUser);
        return aUser.getid();
    }

    @Override
    public void deleteAdminUserById(Integer id) {
        adminUserMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void deleteAdminUsersById(List<Integer> ids) {
        if(CollectionUtils.isEmpty(ids))
            return;
        AdminUserExample adminUserExample = new AdminUserExample();
        adminUserExample.createCriteria().andAIdIn(ids);
        adminUserMapper.deleteByExample(adminUserExample);
    }

    @Override
    public void updateAdminUserById(AdminUser adminUser) {
        AdminUser aUser = new AdminUser();
        BeanUtils.copyProperties(adminUser, aUser);
        int result = adminUserMapper.updateByPrimaryKeySelective(aUser);
        if(result == 0)
            throw new RuntimeException("更新失败，更新结果数为0");
    }
}
