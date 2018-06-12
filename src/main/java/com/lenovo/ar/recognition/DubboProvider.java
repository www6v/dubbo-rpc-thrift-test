package com.lenovo.ar.recognition;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DubboProvider {
	public static void main(String[] args) throws Exception{
//		String path =
//				DubboProvider.class.getPackage().getName().replace(".", "/")
//				+ "/demo-provider.xml";
		
//		ClassPathXmlApplicationContext ctx =
//				new ClassPathXmlApplicationContext(path);
		ClassPathXmlApplicationContext ctx =
				new ClassPathXmlApplicationContext("classpath:/demo-provider.xml");

		ctx.start();
		System.in.read();
	}
}
