package com.noah.springcloud.consumer.service;

import java.util.List;

import com.noah.springcloud.consumer.entity.UserVo;

public interface UserService {

	List<UserVo> getUserList();

	UserVo addUser(Integer userid, String name);

}