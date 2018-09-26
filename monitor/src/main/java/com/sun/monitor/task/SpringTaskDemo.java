package com.sun.monitor.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.sun.monitor.net.NetUtil;


@Component
@PropertySource("classpath:monitorAddr.properties")
public class SpringTaskDemo {

	private static final Logger log = LoggerFactory.getLogger(SpringTaskDemo.class);
	
	@Value("${addr}")
    private String user;

	@Async
	@Scheduled(cron = "0/5 * * * * *")
	public void scheduled1() throws InterruptedException {
		//获取url
		String[] a = user.split(",");
		for (String val:a) {
			NetUtil.getJsonData(val);
		}
	}
}
