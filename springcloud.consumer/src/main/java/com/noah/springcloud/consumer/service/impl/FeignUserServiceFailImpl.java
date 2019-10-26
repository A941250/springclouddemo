package com.noah.springcloud.consumer.service.impl;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.noah.springcloud.consumer.entity.UserVo;
import com.noah.springcloud.consumer.service.FeignUserService;

@Component
public class FeignUserServiceFailImpl implements FeignUserService {

	private AtomicInteger failCount = new AtomicInteger();

	private static Logger logger = LoggerFactory.getLogger(FeignUserServiceFailImpl.class);
	@Override
	public List<UserVo> getUserList() {
		failCount.incrementAndGet();
		logger.error("getUserList fail -->" + failCount.get());
		return null;
	}

	@Override
	public UserVo addUser(Integer userid, String name) {
		failCount.incrementAndGet();
		logger.error("addUser fail -->userid:" + userid + ",name-->" + name + "-----" + failCount.get());
		return new UserVo(userid, "fail");
	}
}
