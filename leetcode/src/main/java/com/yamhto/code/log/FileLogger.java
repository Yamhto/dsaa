package com.yamhto.code.log;

import com.sun.deploy.util.StringUtils;

import java.io.*;

/**
 * @author yamhto
 * @className: FileLogger.java
 * @package com.yamhto.code.log
 * @description:
 * @date 2020/5/18 17:26
 */
public class FileLogger implements Log {

    public static File file = null;

    static {
        file = new File("C:\\Users\\admin_YM\\Desktop\\temp.txt");
    }


    @Override
    public void debug(String str) {
        append(str);
    }

    @Override
    public void error(String str) {
        append(str);
    }

    @Override
    public void info(String str) {
        append(str);
    }

    @Override
    public void warn(String str) {
        append(str);
    }

    private void append(String s) {
        FileWriter fw = null;
        try {
            fw = new FileWriter(file, true);

            fw.append(s + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
