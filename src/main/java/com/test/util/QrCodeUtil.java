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
 * ���ɶ�ά�빤����
 * 
 * @author Chenqi
 *
 */
public class QrCodeUtil {

	/**
	 * ���ɶ�ά�뷽��
	 * 
	 * @param content
	 *            ��ά���ŵ�����
	 * @param imgPath
	 *            ��ά�����ɵ�ͼƬ�Ĵ��·��.
	 */
	public static void encoderQRCode(String content, String imgPath, String logoPath) {
		try {
			// ��ȡqrcode����
			Qrcode qrcodeHandler = new Qrcode();
			// ���ö�ά���Ŵ��ʣ���ѡL(7%)��M(15%)��Q(25%)��H(30%)���Ŵ���Խ�߿ɴ洢����ϢԽ�٣����Զ�ά�������ȵ�Ҫ��ԽС
			qrcodeHandler.setQrcodeErrorCorrect('M');
			// ����ģʽ������:Numeric Ӣ����ĸ��Alphanumeric �����ƣ�Binary ���֣�Kanji
			qrcodeHandler.setQrcodeEncodeMode('B');
			// �汾�� 1-40 ��40���汾�� (1:21x21ģ�飻 2:177x177ģ��)
			qrcodeHandler.setQrcodeVersion(5);
			System.out.println(content);
			// int imgSize = 67 + 12 * (size - 1);
			byte[] contentBytes = content.getBytes("GBK");
			// ����buuferedImage ��С��115��115��
			BufferedImage bufImg = new BufferedImage(115, 115, BufferedImage.TYPE_INT_RGB);
			Graphics2D gs = bufImg.createGraphics();
			gs.setBackground(Color.WHITE);
			gs.clearRect(0, 0, 115, 115);
			// �趨ͼ����ɫ> BLACK
			gs.setColor(Color.BLACK);
			// ����ƫ���� �����ÿ��ܵ��½�������
			int pixoff = 2;
			// �������> ��ά��
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
			// ���ɶ�ά��QRCodeͼƬ
			ImageIO.write(bufImg, "png", imgFile);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * ���ά���в���logo
	 * 
	 * @param image
	 *            ��ά��ͼ��
	 * @param logoPath
	 *            logo·��
	 * @param compress
	 *            �Ƿ�ѹ��
	 * @throws IOException
	 */
	private static void insertImage(BufferedImage image, String logoPath, boolean compress) {
		try {
			// ����ͼƬ�ļ�����
			File file = new File(logoPath);
			// ���ͼƬ������
			if (!file.exists()) {
				System.err.print("���ļ�������" + logoPath);
			}
			// ����Image����
			Image src = ImageIO.read(file);
			int width;
			int height;
			// �Ƿ�ѹ����20��С��
			if (compress) {
				width = 20;
				height = 20;
			} else {
				// ��ȡԭʼ�ߴ�
				width = src.getWidth(null);
				height = src.getHeight(null);
			}
			Image img = src.getScaledInstance(width, height, Image.SCALE_SMOOTH);
			BufferedImage bufImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
			Graphics gs = bufImg.getGraphics();
			gs.drawImage(img, 0, 0, null);
			gs.dispose();
			src = img;

			// ����logo
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
