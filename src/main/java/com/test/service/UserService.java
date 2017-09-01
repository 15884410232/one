package com.test.service;

import java.util.Map;

import org.springframework.stereotype.Service;

public interface UserService {
	public String getUserByName(String userName);
	
	public Map<String,String> redis();
}
