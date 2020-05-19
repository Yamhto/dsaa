package com.yamhto.code.log;

/**
 * @author yamhto
 * @className: ConsoleLogger.java
 * @package com.yamhto.code.log
 * @description:
 * @date 2020/5/18 17:26
 */
public class ConsoleLogger implements Log {

    @Override
    public void debug(String str) {
        System.out.println("============"+str);
    }

    @Override
    public void error(String str) {
        System.out.println("============"+str);
    }

    @Override
    public void info(String str) {
        System.out.println("============"+str);
    }

    @Override
    public void warn(String str) {
        System.out.println("============"+str);
    }
}
