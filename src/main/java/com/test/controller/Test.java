package com.test.controller;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;


public class Test {

	public static void main(String[] args){
//		Jedis jd=new Jedis("127.0.0.1",6378,10000000);
//		jd.set("hello", "ser");
//		jd.close();
		try{
		StringBuffer sb=new StringBuffer();
		sb.append("*3/r/n");
		sb.append("set/r/n");
		sb.append("$5/r/n");
		sb.append("hells/r/n");
		sb.append("$3/r/n");
		sb.append("ser/r/n");
		Socket s=new Socket("localhost",6378);
		OutputStream os=s.getOutputStream();
		os.write(sb.toString().getBytes());
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
	}

}
