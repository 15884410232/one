package com.test.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.ExpiredCredentialsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.test.mapper.UserMapper;
import com.test.service.UserService;

@Controller
public class TestController {

	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private Alipay alipay;

	// @Autowired
	// private JedisCluster jedisCluster;

	@Autowired
	private UserService userService;

	@ResponseBody
	@RequestMapping("test")
	public String test(HttpSession session) {
		String id = session.getId();
		String name = (String) session.getAttribute("name");
		if (null == name) {
			return "null=" + id;
		} else {
			if ("112".equals(name)) {
				return "ok" + "id=" + id;
			} else {
				return "erro" + name + "  id=" + id;
			}
		}
	}

	@ResponseBody
	@RequestMapping("redis")
	public Map<String, String> redis(String name, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// 鍙互璁╂祻瑙堝櫒璺ㄥ煙
		response.setHeader("Access-Control-Allow-Origin", "*");
		session.setAttribute("name", name);
		// jedisCluster.set("hello", "Jinx");
		//
		// String value=jedisCluster.get("hello");
		//
		Map<String, String> res = new HashMap<String, String>();
		//
		// res.put("hello", value);
		res = userService.redis();
		String id = session.getId();
		res.put("id", id);
		return res;
	}

	@RequestMapping(value = "/webuploader")
	@ResponseBody
	public void uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
		System.out.println(file.getOriginalFilename());
		file.transferTo(new File("D:/" + file.getOriginalFilename()));
		System.out.println("锟缴癸拷");
		/* return new Result(true,ok,filename); */
	}
	
	@RequestMapping(value = "/AliPay")
	@ResponseBody
	public void AliPay(HttpServletRequest httpRequest, HttpServletResponse httpResponse) {
		try{
			alipay.doPost(httpRequest, httpResponse);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}


	@RequestMapping(value = "/Ali")
	@ResponseBody
	public Map<String,String> Ali(String app_id,String method,String sign_type,String sign,String charset,
			String timestamp,String aversionpp_id,String auth_app_id,String out_trade_no,String trade_no, String total_amount,String seller_id) throws IOException {
			Map<String,String> data=new HashMap<String,String>();
			data.put("app_id", app_id);
			return data;
		
	}

	@RequestMapping(value = "/getAli")
	@ResponseBody
	public Map<String,String> getAli() throws IOException {
			Map<String,String> data=new HashMap<String,String>();
			alipay.getData();
			return data;
		
	}
	
	@RequestMapping(value = "/getUser")
	@ResponseBody
	public Map<String,String> getUser() throws Exception {
			Map<String,String> data=new HashMap<String,String>();
			return userService.getUserByName("1");
			//return data;
		
	}
	
	
	
	
	@RequestMapping(value = "/dologin")  
	public String doLogin(HttpServletRequest request, Model model) {  
	    String msg = "";  
	    String userName = request.getParameter("userName");  
	    String password = request.getParameter("password"); 
	    System.out.println(userName);  
	    System.out.println(password);  
	    UsernamePasswordToken token = new UsernamePasswordToken(userName, password);  
	    token.setRememberMe(true);  
	    Subject subject = SecurityUtils.getSubject();  
	    try {  
	        subject.login(token);  
	        if (subject.isAuthenticated()) {  
	            return "redirect:/";  
	        } else {  
	            return "login";  
	        }  
	    } catch (IncorrectCredentialsException e) {  
	        msg = "登录密码错误. Password for account " + token.getPrincipal() + " was incorrect.";  
	        model.addAttribute("message", msg);  
	        System.out.println(msg);  
	    } catch (ExcessiveAttemptsException e) {  
	        msg = "登录失败次数过多";  
	        model.addAttribute("message", msg);  
	        System.out.println(msg);  
	    } catch (LockedAccountException e) {  
	        msg = "帐号已被锁定. The account for username " + token.getPrincipal() + " was locked.";  
	        model.addAttribute("message", msg);  
	        System.out.println(msg);  
	    } catch (DisabledAccountException e) {  
	        msg = "帐号已被禁用. The account for username " + token.getPrincipal() + " was disabled.";  
	        model.addAttribute("message", msg);  
	        System.out.println(msg);  
	    } catch (ExpiredCredentialsException e) {  
	        msg = "帐号已过期. the account for username " + token.getPrincipal() + "  was expired.";  
	        model.addAttribute("message", msg);  
	        System.out.println(msg);  
	    } catch (UnknownAccountException e) {  
	        msg = "帐号不存在. There is no user with username of " + token.getPrincipal();  
	        model.addAttribute("message", msg);  
	        System.out.println(msg);  
	    } catch (UnauthorizedException e) {  
	        msg = "您没有得到相应的授权！" + e.getMessage();  
	        model.addAttribute("message", msg);  
	        System.out.println(msg);  
	    }  
	    return "login";  
	}  
	
	
	@RequestMapping("login")
	public String login(HttpSession session) {
		
			return "index";
	}
	
	
	
	
	
}
