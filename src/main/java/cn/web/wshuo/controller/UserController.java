package cn.web.wshuo.controller;

import cn.web.wshuo.dao.UserDao;
import cn.web.wshuo.entity.UserEntity;
import cn.web.wshuo.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Apex_WS at 14:56 on 2017/12/30.
 */

@RestController
@RequestMapping(value = "/userController")
@Api(value = "UserController")

public class UserController {
    @Autowired
    private UserService userService;

    @ApiOperation(value = "获取全部用户", httpMethod = "GET")
    @RequestMapping(value = "/getAllUsers")
    public List<UserEntity> getUsers() {
        List<UserEntity> users = userService.getAllUsers();
        return users;
    }

    @ApiOperation(value = "通过username获取用户", httpMethod = "GET")
    @RequestMapping(value = "/getUserByName")
    public UserEntity getUserByName(@RequestParam("username") String userName) {
        UserEntity user = userService.getUserByName(userName);
        return user;
    }

    @ApiOperation(value = "添加用户", httpMethod = "POST")
    @RequestMapping(value = "/insertUser")
    public void insertUser(@RequestBody UserEntity user) {
        userService.insertUser(user.getUserName(), user.getPassWord(), user.getPowerGroup());
    }

    @ApiOperation(value = "更改用户权限", httpMethod = "POST")
    @RequestMapping(value = "/updateUser")
    public int updateUser(@RequestBody String userName) {
        System.out.println(userName);
        userService.updateUser("administrator", userName);
        return 1;
    }

    @ApiOperation(value = "通过username删除用户", httpMethod = "POST")
    @RequestMapping(value = "/deleteUser")
    public void deleteUser(@RequestParam("username") String userName) {
        userService.deleteUser(userName);
    }

    @ApiOperation(value = "登录信息返回", httpMethod = "GET")
    @RequestMapping(value = "/loginStatus")
    public int loginUser(@RequestBody String userInfo, HttpServletRequest servletRequest) {
        //System.out.println(userInfo);
        String[] info = userInfo.split("\\*");
        if (info.length != 2) return 0;
        UserEntity user = userService.getUserByNameAndPasswd(info[0], info[1]);
        if (user == null) return 0;
        //System.out.println(user.toString());
        servletRequest.getSession().setAttribute(user.getUserName(), user.getPowerGroup());
        if (user.getPowerGroup().equals("administrator")) {
            return 1;
        }
        return -1;
    }

    @ApiOperation(value = "注册用户", httpMethod = "POST")
    @RequestMapping(value = "/registerUser")
    public int registerUser(@RequestBody String userinfo) {
        String[] info = userinfo.split("\\*");
        if (info.length != 2) return 0;
        userService.insertUser(info[0], info[1], "normal");
        return 1;
    }
}















