package io.github.wuwei01.utils;

import javax.servlet.http.HttpServletRequest;

public class IPUtils {
    public static String getIpAddress(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        if (ip != null && ip.contains(",")) {
            ip = ip.split(",")[0];
            if (ip == null || "".equalsIgnoreCase(ip)) {
                ip = request.getLocalAddr();
            }
            return ip.split(",")[0];
        } else {
            if (ip == null || "".equalsIgnoreCase(ip)) {
                ip = request.getLocalAddr();
            }
            return ip;
        }
    }

    /**
     * 获取全写的ipv6地址
     * @param ipv6
     * @return
     */
    public static String getFullIPv6(String ipv6){
        //入参为::时，此时全为0
        if (ipv6.equals("::")){
            return "0000:0000:0000:0000:0000:0000:0000:0000";
        }
        //入参已::结尾时，直接在后缀加0
        if (ipv6.endsWith("::")) {
            ipv6 += "0";
        }
        String[] arrs=ipv6.split(":");
        String symbol="::";
        int arrleng=arrs.length;
        while (arrleng<8){
            symbol+=":";
            arrleng++;
        }
        ipv6=ipv6.replace("::",symbol);
        String fullip="";
        for (String ip:ipv6.split(":")){
            while (ip.length()<4){
                ip="0"+ip;
            }
            fullip+=ip+':';
        }
        return fullip.substring(0,fullip.length()-1);
    }
}
