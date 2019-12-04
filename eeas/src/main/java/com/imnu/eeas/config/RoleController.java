package com.imnu.eeas.config;

import com.imnu.eeas.core.EResponse;
import com.imnu.eeas.pojo.Role;
import com.imnu.eeas.service.RoleService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController extends BaseController {

    @Autowired
    private RoleService roleService;

    @GetMapping("/{id}")
    public EResponse<Role> findById(@PathVariable Integer id) {
        return EResponse.data(roleService.findRoleById(id));
    }

    @GetMapping("/batch/{ids}")
    public EResponse<List<Role>> findByIds(@PathVariable String ids) {
        if(StringUtils.isNotBlank(ids)) {
            String[] split = ids.split(",");
            List<Integer> list = new ArrayList<>();
            for (String id: split) {
                list.add(Integer.valueOf(id.trim()));
            }
            return EResponse.data(roleService.findRolesById(list));
        }
        return EResponse.success();
    }
    @PostMapping("/create")
    public EResponse create(Role req) {
        return EResponse.data(roleService.createNewRole(req));
    }

    @GetMapping("/delete/{id}")
    public EResponse deleteById(@PathVariable Integer id) {
        roleService.deleteRoleById(id);
        return EResponse.success();
    }

    @GetMapping("/delete/batch/{ids}")
    public EResponse deleteByIds(@PathVariable String ids) {
        if(StringUtils.isNotBlank(ids)) {
            String[] split = ids.split(",");
            List<Integer> list = new ArrayList<>();
            for (String id: split) {
                list.add(Integer.valueOf(id.trim()));
            }
            roleService.deleteRolesById(list);
        }
        return EResponse.success();
    }
    @PostMapping("/update")
    public EResponse updateById(Role req) {
        roleService.updateRoleById(req);
        return EResponse.success();
    }
}
