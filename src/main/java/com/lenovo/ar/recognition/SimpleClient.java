package com.lenovo.ar.recognition;

import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.springframework.util.StopWatch;

public class SimpleClient {
	public static void main(String[] args) throws Exception {
		
//		TTransport transport = new TSocket("localhost", 28888);//28088
//		TTransport transport = new TSocket("localhost", 7911);//28088
		TTransport transport = new TSocket("10.4.65.121", 28888);//28088  dev
//		TTransport transport = new TSocket("dev.shai.cloud", 28888);//28088  dev


//		TProtocol protocol = new TBinaryProtocol(transport);
		
		TProtocol protocol = new TBinaryProtocol(new TFramedTransport((transport)));
		
		transport.open();
		
//		HelloService.Client client = new HelloService.Client(protocol);
//		for (int i = 0; i <Integer.MAX_VALUE; i++) {
//			try {
//				String str = client.getString("hello" + i);
//				if (Integer.parseInt(str.substring(5)) != i + 1) {
//					throw new IllegalStateException("result is error!");
//				}
//				System.out.println(str);
//				TimeUnit.SECONDS.sleep(1);
//			} catch(Exception e) {
////				System.out.println("--------------------" + i);
////				System.out.println();
//				e.printStackTrace();
//			}
//		}

		RecognitionServer.Client client1 = new RecognitionServer.Client(protocol);
		RecognitionRequest rr=new RecognitionRequest();

		StopWatch sw = new StopWatch();
		for (int i = 0; i <10; i++) {
			sw.start("recog" + i);
			client1.recognition(rr);
			sw.stop();

			sw.start("getFeature" + i);
			client1.getFeature("tagABC");
			sw.stop();
		}

		transport.close();

		System.out.println(sw.prettyPrint());
		System.out.println(sw.getTotalTimeMillis());
//		System.out.println(sw.getLastTaskName());
//		System.out.println(sw.getLastTaskInfo());
		System.out.println(sw.getTaskCount());

	}
}
