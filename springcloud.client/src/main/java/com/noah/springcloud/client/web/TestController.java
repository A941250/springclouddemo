package com.noah.springcloud.client.web;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.noah.springcloud.client.entity.UserVo;

@RestController
public class TestController {

	private AtomicInteger id = new AtomicInteger();
	
	private static Logger logger = LoggerFactory.getLogger(TestController.class);
	@RequestMapping("/userlist")
	public List<UserVo> userList() {
		logger.info("userlist----");
		List<UserVo> list = new ArrayList<UserVo>();
		UserVo uv = new UserVo(1, "1111111");
		UserVo uv2 = new UserVo(2, "222222");
		UserVo uv3 = new UserVo(3, "333333333333");
		UserVo uv4 = new UserVo(4, "4444444444");
		list.add(uv);
		list.add(uv2);
		list.add(uv3);
		list.add(uv4);
		return list;
	}
	@RequestMapping("/newUser")
	public UserVo newUser(@RequestParam("name") String name) {
		int userId = id.incrementAndGet();
		logger.info("new user-- ----name-->" + name);
		UserVo uv = new UserVo(userId, name);
		return uv;
	}
}
