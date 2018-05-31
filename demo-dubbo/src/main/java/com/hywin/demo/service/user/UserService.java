package com.hywin.demo.service.user;

import com.hywin.demo.user.pojo.User;
import com.hywin.framework.pojo.ResponseEntity;

import java.util.List;

public interface UserService {

	/**
	 * 测试框架
	 * @param id
	 * @return
	 */
	ResponseEntity getNameById(Long id);

	ResponseEntity<List<User>> getUserList(User user);

}
