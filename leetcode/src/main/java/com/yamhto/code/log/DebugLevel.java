package com.yamhto.code.log;


import java.util.Arrays;

/**
 * @author yamhto
 * @className: DebugLevel.java
 * @package com.yamhto.code.log
 * @description:
 * @date 2020/5/18 17:23
 */
public enum DebugLevel {
    DEBUG(1), INFO(2), WARN(3), ERROR(4);

    private int level;

    DebugLevel(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }


    public static DebugLevel getDebugLevel(String str) {
        return Arrays.asList(DebugLevel.values()).stream().filter(temp -> temp.name().toLowerCase().equals(str)).iterator().next();
    }
}
