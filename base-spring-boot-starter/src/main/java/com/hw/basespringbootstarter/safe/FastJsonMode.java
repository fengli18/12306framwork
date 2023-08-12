package com.hw.basespringbootstarter.safe;

import org.springframework.beans.factory.InitializingBean;

public class FastJsonMode implements InitializingBean {
    @Override
    public void afterPropertiesSet() throws Exception {
        System.setProperty("fastjson2.parser.safeMode", "true");
    }
}
