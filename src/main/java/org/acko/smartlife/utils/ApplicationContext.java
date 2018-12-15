package org.acko.smartlife.utils;

/**
 * @author prabodh.hend
 */
public class ApplicationContext {

    private static ThreadLocal<String> requestId = new ThreadLocal<>();

    public static void setCurrentRequestId(String currentRequestId) {
        requestId.set(currentRequestId);
    }

    public static String getCurrentRequestId() {
        return requestId.get();
    }

    public static void removeCurrentRequestId() {
        requestId.remove();
    }

}
