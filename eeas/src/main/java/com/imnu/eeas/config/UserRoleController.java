package com.imnu.eeas.config;

import com.imnu.eeas.core.EResponse;
import com.imnu.eeas.pojo.UserRole;
import com.imnu.eeas.service.UserRoleService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/userrole")
public class UserRoleController extends BaseController {

    @Autowired
    private UserRoleService userRoleService;

    @GetMapping("/{id}")
    public EResponse<UserRole> findById(@PathVariable Integer id) {
        return EResponse.data(userRoleService.findUserRoleById(id));
    }

    @GetMapping("/batch/{ids}")
    public EResponse<List<UserRole>> findByIds(@PathVariable String ids) {
        if(StringUtils.isNotBlank(ids)) {
            String[] idArray = ids.split(",");
            List<Integer> idList = new ArrayList<>();
            for (String id: idArray) {
                idList.add(Integer.valueOf(id.trim()));
            }
            return EResponse.data(userRoleService.findUserRolesById(idList));
        }
        return EResponse.success();
    }
    @PostMapping("/create")
    public EResponse create(UserRole req) {
        return EResponse.data(userRoleService.createNewUserRolefindById(req));
    }

    @GetMapping("/delete/{id}")
    public EResponse deleteById(@PathVariable Integer id) {
        userRoleService.deleteURById(id);
        return EResponse.success();
    }

    @GetMapping("/delete/batch/{ids}")
    public EResponse deleteByIds(@PathVariable String ids) {
        if(StringUtils.isNotBlank(ids)) {
            String[] idArray = ids.split(",");
            List<Integer> idList = new ArrayList<>();
            for (String id: idArray) {
                idList.add(Integer.valueOf(id.trim()));
            }
            userRoleService.deleteURsById(idList);
        }
        return EResponse.success();
    }
    @PostMapping("/update")
    public EResponse updateById(UserRole req) {
        userRoleService.updateURById(req);
        return EResponse.success();
    }
}
