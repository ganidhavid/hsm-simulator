package com.gani.hsmsimulator.util;

import org.beanio.Marshaller;
import org.beanio.StreamFactory;
import org.beanio.Unmarshaller;
import org.beanio.builder.FixedLengthParserBuilder;
import org.beanio.builder.StreamBuilder;

import java.util.HashMap;
import java.util.Map;

public class BeanIOUtilFactory {
    private static Map<String, StreamBuilder> builderHolder = new HashMap();
    private static StreamFactory factory = StreamFactory.newInstance();

    public static Unmarshaller getUnmarshaller(Class aClass) {

        StreamBuilder builder = builderHolder.get(aClass.getName());

        if (null == builder) {
            defineBuilder(aClass);
        }

        return factory.createUnmarshaller(aClass.getName());
    }

    public static Marshaller getMarshaller(Class aClass) {

        StreamBuilder builder = builderHolder.get(aClass.getName());

        if (null == builder) {
            defineBuilder(aClass);
        }

        return factory.createMarshaller(aClass.getName());
    }

    private static void defineBuilder(Class aClass) {
        StreamBuilder builder = new StreamBuilder(aClass.getName())
                .format("fixedlength")
                .parser(new FixedLengthParserBuilder())
                .addRecord(aClass);

        factory.define(builder);
        builderHolder.put(aClass.getName(), builder);
    }
}
