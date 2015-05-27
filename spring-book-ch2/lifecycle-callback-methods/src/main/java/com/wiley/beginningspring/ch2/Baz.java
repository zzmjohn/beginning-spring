package com.wiley.beginningspring.ch2;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Baz implements InitializingBean, DisposableBean {

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("init method invoked");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("destroy method invoked");
	}
	
}
