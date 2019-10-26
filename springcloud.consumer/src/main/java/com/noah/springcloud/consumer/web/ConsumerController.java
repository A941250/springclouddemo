package com.noah.springcloud.consumer.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.noah.springcloud.consumer.entity.UserVo;
import com.noah.springcloud.consumer.service.FeignUserService;
import com.noah.springcloud.consumer.service.UserService;

@RestController
public class ConsumerController {

	@Autowired
	private UserService userService;

	@Autowired
	private FeignUserService feiUserService;

	@GetMapping("/getUserList")
	public List<UserVo> userList() {
		return userService.getUserList();
	}
	@GetMapping("/addUser")
	public UserVo addUser(@RequestParam("id") Integer id, @RequestParam("name") String name) {
		return userService.addUser(id, name);
	}

	@GetMapping("/getUserList2")
	public List<UserVo> userList2() {
		return feiUserService.getUserList();
	}

	@GetMapping("/addUser2")
	public UserVo addUser2(@RequestParam("id") Integer id, @RequestParam("name") String name) {
		return feiUserService.addUser(id, name);
	}
}
