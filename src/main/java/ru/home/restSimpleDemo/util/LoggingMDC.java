package ru.home.restSimpleDemo.util;

import org.slf4j.MDC;

public final class LoggingMDC {
    public LoggingMDC() {
    }
    private static final String REQUEST_UID = "requestUid";

    public static void addRqUidToMdc(String rqUid){
        MDC.put(REQUEST_UID, rqUid);
    }

    public static String getRequestUid(){
        return MDC.get(REQUEST_UID);
    }

    public static void cleanMDC(){
        MDC.remove(REQUEST_UID);
    }
}
