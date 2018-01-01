package cn.web.wshuo.service;

import cn.web.wshuo.dao.UserDao;
import cn.web.wshuo.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Apex_WS at 19:57 on 2017/12/30.
 */

@Service

public class UserService {
    @Autowired
    private UserDao userDao;

    //get all users's info
    public List<UserEntity> getAllUsers() {
        List<UserEntity> users = userDao.getAllUsers();
        return users;
    }

    //get a user's info by userName
    public UserEntity getUserByName(String userName) {
        UserEntity user = userDao.getUserByName(userName);
        return user;
    }

    //get a user's info by userName & passWord
    public UserEntity getUserByNameAndPasswd(String userName, String passWord) {
        UserEntity user = userDao.getUserByNameAndPasswd(userName, passWord);
        return user;
    }

    //insert a user
    public void insertUser(String userName, String passWord, String powerGroup) {
        userDao.insertUser(userName, passWord, powerGroup);
    }

    //update a user's power by userName
    public void updateUser(String powerGroup, String userName) {
        userDao.updateUser(powerGroup, userName);
    }

    //delete a user by userName
    public void deleteUser(String userName) {
        userDao.deleteUser(userName);
    }
}
