package com.demoApp.library;

import org.apache.log4j.Logger;


public class Log {

    static Logger Log = Logger.getLogger(Log.class);

    public Log() {
        Log = Logger.getLogger(Log.getClass().getName());
    }

    public static void info(String message) {
        Log.info(message);
    }

    public static long startTime() {
        long x = System.currentTimeMillis();
        return (x);
    }

    /**
     * elapsedTime : This method is to returns time difference
     *
     * @return Time difference
     */
    public static long elapsedTime(long startTime) {
        return ((System.currentTimeMillis() - startTime) / 1000);
    }

    public static void error(String message) {
        Log.error(message);
    }

}