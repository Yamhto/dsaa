package com.yamhto.code.log;

/**
 * @author yamhto
 * @className: Test.java
 * @package com.yamhto.code.log
 * @description:
 * @date 2020/5/18 17:27
 */
public class Test {

    public static void main(String[] args) {

        LoggerFactory.setDebugLevel(DebugLevel.INFO);
        final Log logger1 = LoggerFactory.getLogger(ConsoleLogger.class);
        logger1.debug("debug 1...");

        logger1.debug("debug 2...");

        logger1.info("info 1...");

        logger1.warn("warn 1...");

        logger1.error("error 1...");

       /* LoggerFactory.setDebugLevel(DebugLevel.ERROR);
        final Log logger2 = LoggerFactory.getLogger(FileLogger.class);
        logger2.debug("debug 1...");

        logger2.debug("debug 2...");

        logger2.info("info 1...");

        logger2.warn("warn 1...");

        logger2.error("error 1...");*/

    }
}
