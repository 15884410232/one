package com.test.controller;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonObjectFormatVisitor;
import com.test.util.FaceUtil;

import net.sf.json.JSONObject;
import redis.clients.jedis.JedisCluster;

@Controller
public class HomeController {

	@Autowired
	private JedisCluster jedisCluster;
	
	@RequestMapping("home")
	public String home(){
		return "home";
	}
	@RequestMapping("hello")
	public String hello(){
		return "face";
	}
	@ResponseBody
	@RequestMapping("face")
	public String  face(@RequestParam("file") MultipartFile file){
		try{
		System.out.println(file.getOriginalFilename());
		file.transferTo(new File("D:/test/" + file.getOriginalFilename()));
		File files=new File("D:/"+file.getOriginalFilename());
		Face face=new Face();
		String token=face.getToken(files);
		FaceUtil faceutil=new FaceUtil();
		String data=null;
		for(int i=0;i<5;i++){
		 data=faceutil.getData(token,files);
		 if(data!=null){
			 break;
		 }
		}
		if(data!=null){
			jedisCluster.set("jj", data);
		}
		JSONObject jsonob=JSONObject.fromObject(data);
		return data;
		}catch(Exception ex){
			ex.printStackTrace();
			return "rs";
		}
	}
}
