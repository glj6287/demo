package com.hywin.demo.service.user;

import com.alibaba.druid.util.StringUtils;
import com.hywin.demo.dao.user.UserDao;
import com.hywin.demo.user.pojo.User;
import com.hywin.framework.pojo.ResponseEntity;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wuyouyang on 2017/4/24.
 */
@Service
public class UserServiceImpl implements UserService {
    private final Logger logger = LogManager.getLogger(this.getClass());

    @Autowired
    private UserDao userDao;

    public ResponseEntity getNameById(Long id) {
        logger.log(Level.getLevel("BIZ"), "test biz level log message");
        logger.error("test separate file");
        String name = null;
        try {
            name = userDao.getNameById(id);
        } catch (Exception e) {
            logger.debug(e.getMessage());
        }
        return new ResponseEntity(name);
    }

    public ResponseEntity<List<User>> getUserList(User user) {
        if(StringUtils.isEmpty(user.getUserCode())) {
            throw new IllegalArgumentException("用户Code不能为空！");
        }
        List<User> list = userDao.selectUserList(user);
        return new ResponseEntity(list);
    }
}
