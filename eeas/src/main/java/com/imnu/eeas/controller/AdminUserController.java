package com.imnu.eeas.config;

import com.imnu.eeas.core.EResponse;
import com.imnu.eeas.pojo.AdminUser;
import com.imnu.eeas.service.AdminUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminUserController extends BaseController{

    @Autowired
    private AdminUserService adminUserService;

    public void login(@RequestBody AdminUser adminUser) {
        String name = adminUser.getName();
        name = HtmlUtils.htmlEscape(name);

        AdminUser user = adminUserService.login(adminUser);

    }


    @GetMapping("/{id}")
    public EResponse<AdminUser> findById(@PathVariable Integer id){
        return EResponse.data(adminUserService.findAdminUserById(id));
    }

    @GetMapping("/batch/{ids}")
    public EResponse<List<AdminUser>> findByIds(@PathVariable String ids){
        if (StringUtils.isNotBlank(ids)){
            String[] split = ids.split(",");
            List<Integer> list = new ArrayList<>();
            for (String id : split) {
                list.add(Integer.valueOf(id.trim()));
            }
            return EResponse.data(adminUserService.findAdminUsersById(list));
        }
        return EResponse.success();
    }

    @PostMapping("/create")
    public EResponse Create(AdminUser req){
        return EResponse.data(adminUserService.createNewAdminUser(req));
    }

    @GetMapping("/delete/{id}")
    public EResponse deleteById(@PathVariable Integer id){
        adminUserService.deleteAdminUserById(id);
        return EResponse.success();
    }

    @GetMapping("/delete/batch/{ids}")
    public EResponse deleteByIds(@PathVariable String ids){
        if (StringUtils.isNotBlank(ids)){
            String[] split = ids.split(",");
            List<Integer> list = new ArrayList<>();
            for (String id : split) {
                list.add(Integer.valueOf(id.trim()));
            }
            adminUserService.deleteAdminUsersById(list);
        }
        return EResponse.success();
    }

    @PostMapping("/update")
    public EResponse updateById(AdminUser req){
        adminUserService.updateAdminUserById(req);
        return EResponse.success();
    }
}
