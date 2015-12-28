package com.vanroid.gduf.service.impl.jwc;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.springframework.stereotype.Service;

import com.vanroid.gduf.dto.JwcInfo;

/**
 * 
 * @ClassName JwcLoginService.java Create on 2015年8月28日
 * 
 * @company Copyright (c) 2015 by Vanroid Team
 * 
 * @author Jerry 983951558@qq.com
 * 
 * @Description: 教务系统的登陆service类
 * 
 * @version 1.0
 */
@Service("loginService")
public class JwcLoginService {
	private JWCHandler handler = new JWCHandler();
	private String xm;
	public String login(JwcInfo info) {
		// TODO 自动生成的构造函数存根
		try {
			xm=handler.login(info);
		} catch (ClientProtocolException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return xm;
		
	}
}
