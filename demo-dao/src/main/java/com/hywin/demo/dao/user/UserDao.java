package com.hywin.demo.dao.user;

import com.hywin.demo.user.pojo.User;

import java.util.List;

/**
 * Created by wuyouyang on 2017/4/24.
 */
public interface UserDao {
    String getNameById(Long id);
    List<User> selectUserList(User user);
}
