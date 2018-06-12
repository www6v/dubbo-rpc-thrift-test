package com.lenovo.ar.recognition;


import org.apache.thrift.TException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangwei110 on 2018/6/8.
 */
public class RecognitionServerImpl implements RecognitionServer.Iface {
    @Override
    public RecognitionResult recognition(RecognitionRequest request) throws TException {
        String a= "a";
        List<Double> l = new ArrayList<Double>();
        l.add(1.2);
        l.add(2.3);

        RecognitionResult rr = new RecognitionResult();

        rr.setSuccess(true);
        rr.setTag("tag1");
        rr.setFeatureUrl("http://FeatureUrl");
        rr.setModelUrl("http://ModelUrl");
        rr.setData(a.getBytes());

        rr.setTarget2camera(l);

        System.out.println("In regco service .");
        return rr;
    }
}
