package com.test.service;

import java.util.Map;

import org.springframework.stereotype.Service;

public interface UserService {
	public Map<String,String> getUserByName(String userName);
	
	public Map<String,String> redis();
}
