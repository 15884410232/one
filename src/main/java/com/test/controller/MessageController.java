package com.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.test.util.MessageUtil;

@Controller
public class MessageController {

	@Autowired
	private MessageUtil messageUtil;
	
	public void test(){
		messageUtil.sendMessage("13980937230", "î£ÖÇµÄÄã");
	}
	@RequestMapping("message")
	public void test3(){
		test();
	}

}
