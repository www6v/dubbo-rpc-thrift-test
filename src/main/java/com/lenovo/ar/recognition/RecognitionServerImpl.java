package com.lenovo.ar.recognition;

import org.apache.thrift.TException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangwei110 on 2018/6/8.
 */
public class RecognitionServerImpl implements RecognitionServer.Iface {

    @Override
    public String getFeature(String tag) throws TException {
        System.out.println("In getFeature service .");
        return "mock Feature";
    }

    @Override
    public RecognitionResult recognition(RecognitionRequest request) throws TException {
        String a= "a";
        List<Double> l = new ArrayList<Double>();
        l.add(1.2);
        l.add(2.3);

        RecognitionResult rResult = new RecognitionResult();

        rResult.setSuccess(true);
        rResult.setTag("tag1");
        rResult.setTarget2camera(l);
        rResult.setFeatureUrl("http://FeatureUrl");

        System.out.println("In regco service .");
        return rResult;
    }
}
