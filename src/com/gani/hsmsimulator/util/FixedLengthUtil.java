package com.gani.hsmsimulator.util;

import org.beanio.Marshaller;
import org.beanio.StreamFactory;
import org.beanio.Unmarshaller;
import org.beanio.builder.FixedLengthParserBuilder;
import org.beanio.builder.StreamBuilder;

import java.util.HashMap;
import java.util.Map;

public class FixedLengthUtil {
    private static Map<String, Holder> holderMap = new HashMap();
    private static StreamFactory factory = StreamFactory.newInstance();

    private static Unmarshaller getUnmarshaller(Class aClass) {
        Holder holder = holderMap.get(aClass.getName());
        if (null == holder) defineHolder(aClass);

        return holderMap.get(aClass.getName()).getUnmarshaller();
    }

    private static Marshaller getMarshaller(Class aClass) {
        Holder holder = holderMap.get(aClass.getName());
        if (null == holder) defineHolder(aClass);

        return holderMap.get(aClass.getName()).getMarshaller();
    }

    private static void defineHolder(Class aClass) {
        factory.define(new StreamBuilder(aClass.getName())
                .format("fixedlength")
                .parser(new FixedLengthParserBuilder())
                .addRecord(aClass));
        Unmarshaller unmarshaller = factory.createUnmarshaller(aClass.getName());
        Marshaller marshaller = factory.createMarshaller(aClass.getName());

        Holder holder = new Holder(unmarshaller, marshaller);
        holderMap.put(aClass.getName(), holder);
    }

    public static <T> T unmarshal(String string, Class<T> aClass){
        Unmarshaller unmarshaller = FixedLengthUtil.getUnmarshaller(aClass);
        return (T) unmarshaller.unmarshal(string);
    }

    public static String marshal(Object obj){
        Marshaller marshaller = FixedLengthUtil.getMarshaller(obj.getClass());
        return marshaller.marshal(obj).toString();
    }
}
