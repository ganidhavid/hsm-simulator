package com.gani.hsmsimulator.util;

import org.beanio.Marshaller;
import org.beanio.Unmarshaller;

public class Holder {
    private Unmarshaller unmarshaller;
    private Marshaller marshaller;

    public Holder(Unmarshaller unmarshaller, Marshaller marshaller) {
        this.unmarshaller = unmarshaller;
        this.marshaller = marshaller;
    }

    public Unmarshaller getUnmarshaller() {
        return unmarshaller;
    }

    public void setUnmarshaller(Unmarshaller unmarshaller) {
        this.unmarshaller = unmarshaller;
    }

    public Marshaller getMarshaller() {
        return marshaller;
    }

    public void setMarshaller(Marshaller marshaller) {
        this.marshaller = marshaller;
    }
}
