package com.test.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.mapper.UserMapper;
import com.test.service.UserService;

import redis.clients.jedis.JedisCluster;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private JedisCluster jedisCluster;
	
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public Map<String,String> getUserByName(String userName) {
		return userMapper.getUserInfo().get(0);
	}

	@Override
	public Map<String, String> redis() {
		Map<String,String> res=new HashMap<String,String>();
		jedisCluster.set("hello", "ok");
		String value=jedisCluster.get("hello");
		res.put("hello", value);
		return res;
	}

}
