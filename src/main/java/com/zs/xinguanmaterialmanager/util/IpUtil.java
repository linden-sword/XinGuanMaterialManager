package com.zs.xinguanmaterialmanager.util;

import eu.bitwalker.useragentutils.UserAgent;

import javax.servlet.http.HttpServletRequest;

import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;

public class IpUtil {


    public static String getIpAddr(HttpServletRequest request) {

        String  ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        if ("0:0:0:0:0:0:0:1".equals(ip)) {
            ip = "127.0.0.1";
        }
        if (ip.split(",").length >= 1) {
            ip = ip.split(",")[0];
        }
        return ip;
    }
}