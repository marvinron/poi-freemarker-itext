package com.poi.util;

import java.io.File;

/**
 * @author houlei
 * @DESC:路径工具类
 * @create 2018-12-21 11:35
 */
public class PathUtil {

    public static String getCurrentPath() {

        Class<?> caller = getCaller();
        if (caller == null) {
            caller = PathUtil.class;
        }

        return getCurrentPath(caller);
    }


    public static Class<?> getCaller() {
        StackTraceElement[] stack = (new Throwable()).getStackTrace();
        if (stack.length < 3) {
            return PathUtil.class;
        }
        String className = stack[2].getClassName();
        try {
            return Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getCurrentPath(Class<?> cls) {
        String path = cls.getProtectionDomain().getCodeSource().getLocation().getPath();
        path = path.replaceFirst("file:/", "");
        path = path.replaceAll("!/", "");
        if (path.lastIndexOf(File.separator) >= 0) {
            path = path.substring(0, path.lastIndexOf(File.separator));
        }
        if ("/".equalsIgnoreCase(path.substring(0, 1))) {
            String osName = System.getProperty("os.name").toLowerCase();
            if (osName.contains("window")) {
                path = path.substring(1);
            }
        }
        return path;
    }

    public static void main(String[] args) {
        System.out.println(getCurrentPath());

    }
}
