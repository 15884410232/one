package com.test.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.test.mapper.UserMapper;
import com.test.service.UserService;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;

@Controller
public class TestController {

	@Autowired
	private UserMapper userMapper;

	// @Autowired
	// private JedisCluster jedisCluster;

	@Autowired
	private UserService userService;

	@ResponseBody
	@RequestMapping("test")
	public String test(HttpSession session) {
		String id=session.getId();
		String name=(String) session.getAttribute("name");
		if(null==name){
			return "null="+id;
		}else{
			if("112".equals(name)){
				return "ok"+"id="+id;
			}else{
				return "erro"+name+"  id="+id;
			}
		}
	}

	@ResponseBody
	@RequestMapping("redis")
	public Map<String, String> redis(String name,HttpServletRequest request,HttpServletResponse response,HttpSession session) {
		//可以让浏览器跨域
		response.setHeader("Access-Control-Allow-Origin", "*"); 
		session.setAttribute("name", name);
		// jedisCluster.set("hello", "Jinx");
		//
		// String value=jedisCluster.get("hello");
		//
		Map<String, String> res = new HashMap<String, String>();
		//
		// res.put("hello", value);
		res=userService.redis();
		String id=session.getId();
		res.put("id", id);
		return res;
	}

	@RequestMapping(value = "/webuploader")
	@ResponseBody
	public void uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
		System.out.println(file.getOriginalFilename());
		file.transferTo(new File("D:/" + file.getOriginalFilename()));
		System.out.println("�ɹ�");
		/* return new Result(true,ok,filename); */
	}

}
