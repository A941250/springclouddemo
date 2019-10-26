package com.noah.springcloud.consumer.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.noah.springcloud.consumer.entity.UserVo;
import com.noah.springcloud.consumer.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	@Autowired
	RestTemplate restTemplate;

	@Override
	@HystrixCommand(fallbackMethod = "userListFail")
    public List<UserVo> getUserList() {
		logger.info("getUserList begin-->");
		List<UserVo> list = restTemplate.getForObject("http://SERVICE-HELLOWORLD/userlist", List.class);
		logger.info("getUserList end-->");
		return list;
	}

	@Override
	@HystrixCommand(fallbackMethod = "addUserFail")
    public UserVo addUser(Integer userid, String name) {
		logger.info("addUser begin-->userid-->" + userid + ",name-->" + name);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userid", userid);
		params.put("name", name);
		ResponseEntity<UserVo> response = restTemplate.postForEntity(
		        "http://SERVICE-HELLOWORLD/newUser?userid={userid}&name={name}", null,
		        UserVo.class, params);
		logger.info("addUser end-->userid-->" + userid + ",name-->" + name);
		return response.getBody();
	}
	

	public String getHelloContent() {
		return restTemplate.getForObject("http://SERVICE-HELLOWORLD/", String.class);
	}

	public List<UserVo> userListFail() {
		logger.error("userListFail begin");
		return null;
	}

	public UserVo addUserFail(Integer id, String name) {
		logger.error("addUser eror-->userid-->" + id + ",name-->" + name);
		return null;
	}
}
