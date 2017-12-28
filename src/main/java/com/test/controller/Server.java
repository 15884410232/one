package com.test.controller;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) throws Exception{
		try {
			ServerSocket server=new ServerSocket(6378);
			server.setSoTimeout(1000000000);
			Socket s=server.accept();
			s.setSoTimeout(100000000);
			byte[] re=new byte[1024];
			InputStream in=s.getInputStream();
			in.read(re);
			System.out.println(new String(re));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
