package com.yamhto.code.log;

/**
 * @author yamhto
 * @className: LogConfiguration.java
 * @package com.yamhto.code.log
 * @description:
 * @date 2020/5/18 17:46
 */
public class LogConfiguration {

    private DebugLevel debugLevel;

    //private HashMap<packageStr,DebugLevel> DebugLevels;

    public DebugLevel getDebugLevel() {
        return debugLevel;
    }

    public void setDebugLevel(DebugLevel debugLevel) {
        this.debugLevel = debugLevel;
    }
}
