package com.test.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import sun.misc.BASE64Encoder;

/**
 * 文件复制
 * @author Chenqi
 *
 */
public class CopyFileUtil {

	/**
	 * 文件复制
	 * 
	 * @param sourceFilePath 源文件路径
	 * @param targetFilePath 新文件路径
	 */
	public void copyFile(String sourceFilePath, String targetFilePath) {
		try {
			// 源文件输入流
			FileInputStream in = new FileInputStream(new File(sourceFilePath));
			// 新文件输出流
			FileOutputStream out = new FileOutputStream(new File(targetFilePath));
			// byte
			byte[] bytes = new byte[1024];
			int len = 0;
			while ((len = in.read(bytes)) != -1) {
				out.write(bytes, 0, len);
			}
			in.close();
			out.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
