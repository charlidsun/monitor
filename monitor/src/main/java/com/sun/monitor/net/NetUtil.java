package com.sun.monitor.net;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NetUtil {
	
	private static Logger logger = LoggerFactory.getLogger(NetUtil.class);

	public static String getJsonData(String urls) {
		
		try {
			URL url = new URL(urls.trim());
			// 打开连接
			HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
			urlConnection.setConnectTimeout(5000);
			System.out.println("ok");
		} catch (IOException e) {
			//写入本地日志中
			logger.error(urls+" --> 连接超时");
			e.printStackTrace();
		}

		return null;

	}
}
