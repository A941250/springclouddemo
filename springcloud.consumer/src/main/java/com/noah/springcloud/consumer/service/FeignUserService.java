package com.noah.springcloud.consumer.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.noah.springcloud.consumer.entity.UserVo;
import com.noah.springcloud.consumer.service.impl.FeignUserServiceFailImpl;

@FeignClient(value = "SERVICE-HELLOWORLD", fallback = FeignUserServiceFailImpl.class)
public interface FeignUserService {
	@RequestMapping(value = "/userlist", method = RequestMethod.GET)
	List<UserVo> getUserList();

	@RequestMapping(value = "/newUser", method = RequestMethod.GET)
	UserVo addUser(@RequestParam("userid") Integer userid, @RequestParam("name") String name);
}
