package com.lenovo.ar.recognition;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.StopWatch;

public class TestDubboConsumer {
	
	public static void main(String[] args) throws Exception{
//		String path =
//				DubboConsumer.class.getPackage().getName().replace(".", "/")
//				+ "/demo-consumer.xml";
//
//		ClassPathXmlApplicationContext ctx =
//				new ClassPathXmlApplicationContext(path);

		ClassPathXmlApplicationContext ctx =
				new ClassPathXmlApplicationContext("classpath:/demo-consumer.xml");

//		final HelloService.Iface service = (HelloService.Iface) ctx.getBean("helloService");
// 		service.getUser(1, "tom", 24);

		final RecognitionServer.Iface service = (RecognitionServer.Iface) ctx.getBean("recognitionService");

		StopWatch sw = new StopWatch();

		for(int i = 0; i<10; i++) {
//			User user = service.getUser(1, "tom", 24);
			RecognitionRequest rr=new RecognitionRequest();
			sw.start("recog" + i);
			service.recognition(rr);
			sw.stop();

			sw.start("getFeature" + i);
			service.getFeature("tag");
			sw.stop();
		}

		System.out.println(sw.prettyPrint());
		System.out.println(sw.getTotalTimeMillis());
		System.out.println(sw.getLastTaskName());
		System.out.println(sw.getLastTaskInfo());
		System.out.println(sw.getTaskCount());
	}
}
