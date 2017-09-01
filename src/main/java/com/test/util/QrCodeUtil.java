package com.test.util;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.swetake.util.Qrcode;

/**
 * 生成二维码工具类
 * 
 * @author Chenqi
 *
 */
public class QrCodeUtil {

	/**
	 * 生成二维码方法
	 * 
	 * @param content
	 *            二维码存放的内容
	 * @param imgPath
	 *            二维码生成的图片的存放路径.
	 */
	public static void encoderQRCode(String content, String imgPath, String logoPath) {
		try {
			// 获取qrcode对象
			Qrcode qrcodeHandler = new Qrcode();
			// 设置二维码排错率，可选L(7%)、M(15%)、Q(25%)、H(30%)，排错率越高可存储的信息越少，但对二维码清晰度的要求越小
			qrcodeHandler.setQrcodeErrorCorrect('M');
			// 编码模式：数字:Numeric 英文字母：Alphanumeric 二进制：Binary 汉字：Kanji
			qrcodeHandler.setQrcodeEncodeMode('B');
			// 版本： 1-40 共40个版本： (1:21x21模块； 2:177x177模块)
			qrcodeHandler.setQrcodeVersion(5);
			System.out.println(content);
			// int imgSize = 67 + 12 * (size - 1);
			byte[] contentBytes = content.getBytes("GBK");
			// 创建buuferedImage 大小是115宽，115高
			BufferedImage bufImg = new BufferedImage(115, 115, BufferedImage.TYPE_INT_RGB);
			Graphics2D gs = bufImg.createGraphics();
			gs.setBackground(Color.WHITE);
			gs.clearRect(0, 0, 115, 115);
			// 设定图像颜色> BLACK
			gs.setColor(Color.BLACK);
			// 设置偏移量 不设置可能导致解析出错
			int pixoff = 2;
			// 输出内容> 二维码
			if (contentBytes.length > 0 && contentBytes.length < 800) {
				boolean[][] codeOut = qrcodeHandler.calQrcode(contentBytes);
				for (int i = 0; i < codeOut.length; i++) {
					for (int j = 0; j < codeOut.length; j++) {
						if (codeOut[j][i]) {
							gs.fillRect(j * 3 + pixoff, i * 3 + pixoff, 3, 3);
						}
					}
				}
			} else {
				System.err.println("QRCode content bytes length = " + contentBytes.length + " not in [ 0,800 ]. ");
			}
			gs.dispose();
			bufImg.flush();
			File imgFile = new File(imgPath);
			insertImage(bufImg, logoPath, true);
			// 生成二维码QRCode图片
			ImageIO.write(bufImg, "png", imgFile);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 向二维码中插入logo
	 * 
	 * @param image
	 *            二维码图层
	 * @param logoPath
	 *            logo路径
	 * @param compress
	 *            是否压缩
	 * @throws IOException
	 */
	private static void insertImage(BufferedImage image, String logoPath, boolean compress) {
		try {
			// 创建图片文件对象
			File file = new File(logoPath);
			// 如果图片不存在
			if (!file.exists()) {
				System.err.print("该文件不存在" + logoPath);
			}
			// 生成Image对象
			Image src = ImageIO.read(file);
			int width;
			int height;
			// 是否压缩到20大小；
			if (compress) {
				width = 20;
				height = 20;
			} else {
				// 获取原始尺寸
				width = src.getWidth(null);
				height = src.getHeight(null);
			}
			Image img = src.getScaledInstance(width, height, Image.SCALE_SMOOTH);
			BufferedImage bufImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
			Graphics gs = bufImg.getGraphics();
			gs.drawImage(img, 0, 0, null);
			gs.dispose();
			src = img;

			// 插入logo
			Graphics2D gs2d = image.createGraphics();
			int x = (image.getWidth() - width) / 2;
			int y = (image.getHeight() - height) / 2;
			// x=150;
			// y=150;
			gs2d.drawImage(src, x, y, width, height, null);
			Shape shape = new RoundRectangle2D.Float(x, y, width, height, 6, 6);
			gs2d.setStroke(new BasicStroke(3f));
			gs2d.draw(shape);
			gs2d.dispose();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
