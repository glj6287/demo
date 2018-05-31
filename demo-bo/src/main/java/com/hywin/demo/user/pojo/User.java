package com.hywin.demo.user.pojo;

import com.hywin.framework.pojo.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
public class User extends Entity {
	private Long id;
	private String userCode;
	private String name;
}
