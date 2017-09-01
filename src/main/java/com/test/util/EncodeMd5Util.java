package com.test.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import org.apache.commons.codec.binary.Base64;

/**
 * 数据md5加密
 * @author Chenqi
 *
 */
public class EncodeMd5Util {

	/**
	 * 数据md5加密方法
	 * 
	 * @param str
	 *            需要加密的字符串
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException
	 */
	public static String EncoderByMd5(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		// md5对象
		MessageDigest md5 = MessageDigest.getInstance("MD5");
		// base64对象
		Base64 base64 = new Base64();
		// 将数据加密
		byte[] md5str = md5.digest(str.getBytes("utf-8"));
		// 将加密数据转码
		byte[] base64str = base64.encode(md5str);
		// 将转码加密数据解码
		byte[] md5strs = base64.decode(base64str);
		// Array.toString()遍历数组
		System.out.println(Arrays.toString(md5str));
		System.out.println(Arrays.toString(md5strs));

		return new String(base64str, "utf-8");
	}
}
