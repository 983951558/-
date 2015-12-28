package com.vanroid.gduf.test.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.ClientProtocolException;
import org.junit.Test;

import com.vanroid.gduf.util.HttpClientUtils;

public class HttpClientUtilsTest {

	@Test
	public void testGet(){
		try {
			
			String body = HttpClientUtils.get(null, "http://www.gduf.edu.cn", null, null).getBody();
			System.out.println(body);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testPost(){
		try {
			Map<String,String> params = new HashMap<String,String>();
			params.put("username", "131545230");
			params.put("password", "");
			String body = HttpClientUtils.post(null, "http://www.gduf.edu.cn/checkuser.jsp", null, params, "utf-8").getBody();
			
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
