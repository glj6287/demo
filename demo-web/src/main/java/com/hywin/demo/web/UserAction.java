package com.hywin.demo.web;

import com.hywin.demo.service.user.UserService;
import com.hywin.demo.user.pojo.User;
import com.hywin.framework.pojo.Page;
import com.hywin.framework.pojo.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
/**
 * Created by wuyouyang on 2017/4/24.
 */
@Controller
@RequestMapping("user")
public class UserAction {

    @Resource
	private UserService userServiceImpl;

    @RequestMapping(value = "/getUserName/{id}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public ResponseEntity getUserName(@PathVariable Long id) {
		ResponseEntity ret = userServiceImpl.getNameById(id);
		return ret;
	}

	@RequestMapping(value = "/getUserList", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public ResponseEntity<List<User>> getUserList(User user) {
		if(user == null) {
			user = new User();
		}
		Page page = user.getPage();
		if(null == page){
			page = new Page();
			user.setPage(page);
		}
		ResponseEntity<List<User>> ret = userServiceImpl.getUserList(user);
		return ret;
	}
}
