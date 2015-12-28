package com.vanroid.gduf.service.circle;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import sun.misc.BASE64Decoder;

import com.vanroid.gduf.entity.Circle;
import com.vanroid.gduf.entity.ImagePath;

/**
 * 
 * @ClassName ImgUtils.java Create on 2015年8月31日
 * 
 * @company Copyright (c) 2015 by Vanroid Team
 * 
 * @author Jerry 983951558@qq.com
 * 
 * @Description: 朋友圈图片处理工具，负责将base64码转换成图片文件并生成本地存储路径
 * 
 * @version 1.0
 */
public class ImgUtils {
	public static List<ImagePath> codeToPath(Circle circle, String[] imageCode)
			throws IOException {
		List<ImagePath> list = new ArrayList<ImagePath>();
		for (int i = 0; i < imageCode.length; i++) {
			ImagePath ip = new ImagePath();
			String path = codeToFile(imageCode[i]);
			ip.setTid(circle);
			ip.setPath(path);
			list.add(ip);
		}

		return list;

	}

	/**
	 * 将图片base64码转换成图片文件file
	 * 
	 * @param code
	 * @return
	 * @throws IOException
	 */
	public static String codeToFile(String code) throws IOException {
		BASE64Decoder decoder = new BASE64Decoder();
		String fileName = null;

		// Base64解码
		byte[] bytes = null;
		try {
			bytes = decoder.decodeBuffer(code);
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		for (int i = 0; i < bytes.length; ++i) {
			if (bytes[i] < 0) {// 调整异常数据
				bytes[i] += 256;
			}
		}
		
		fileName =new SimpleDateFormat("yyyyMMddhhmmssSSS").format(new Date());
		File imgFile = new File("F:/project/gduf.web/src/main/webapp/picture" + fileName + ".jpg");
		if(imgFile==null)
			imgFile.mkdir();
		OutputStream out = null;
		try {
			out = new FileOutputStream(imgFile);
		} catch (FileNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		try {
			out.write(bytes);
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		out.flush();
		out.close();

		return "F:/project/gduf.web/src/main/webapp/picture/" + fileName + ".jpg";
	}

}
