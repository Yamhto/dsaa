package com.yamhto.code.log;

import net.sf.cglib.proxy.Enhancer;

/**
 * @author yamhto
 * @className: LoggerFactory.java
 * @package com.yamhto.code.log
 * @description:
 * @date 2020/5/19 9:19
 */
public class LoggerFactory {

    public static LogConfiguration configuration;

    static {
        configuration = new LogConfiguration();
    }

    public static Log getLogger(Class clazz) {
        Enhancer enhancer = new Enhancer();

        enhancer.setSuperclass(clazz);

        enhancer.setCallback(new LogProxy(configuration.getDebugLevel()));

        return (Log) enhancer.create();

    }

    static void setDebugLevel(DebugLevel debugLevel) {
        configuration.setDebugLevel(debugLevel);
    }
}
