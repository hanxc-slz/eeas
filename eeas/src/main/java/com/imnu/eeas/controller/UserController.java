package com.imnu.eeas.config;

import com.imnu.eeas.core.EResponse;
import com.imnu.eeas.pojo.User;
import com.imnu.eeas.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public EResponse<User> findById(@PathVariable Integer id) {
        return EResponse.data(userService.findUserById(id));
    }

    @GetMapping("/batch/{ids}")
    public EResponse<List<User>> findByIds(@PathVariable String ids) {
        if(StringUtils.isNotBlank(ids)) {
            String[] split = ids.split(",");
            List<Integer> list = new ArrayList<>();
            for (String id: split) {
                list.add(Integer.valueOf(id.trim()));
            }
            return EResponse.data(userService.findUsersById(list));
        }
        return EResponse.success();
    }
    @PostMapping("/create")
    public EResponse create(User req) {
        return EResponse.data(userService.createNewUser(req));
    }
    @GetMapping("/delete/{id}")
    public EResponse deleteById(@PathVariable Integer id) {
        userService.deleteUserById(id);
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
            userService.deleteUsersById(list);
        }
        return EResponse.success();
    }
    @PostMapping("/update")
    public EResponse updateById(User req) {
        userService.updateUserById(req);
        return EResponse.success();
    }
}
