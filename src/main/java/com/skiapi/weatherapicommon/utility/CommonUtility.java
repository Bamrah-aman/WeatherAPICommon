package com.skiapi.weatherapicommon.utility;

import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.LoggerFactory;

import java.util.logging.Logger;

public class CommonUtility {

    private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(CommonUtility.class);

    public static String getIPAddress(HttpServletRequest request) {
        String ip = request.getHeader("X-FORWARED-FOR");

        if(ip == null || ip.isEmpty()){
            ip = request.getRemoteAddr();
        }
        LOGGER.info("Clients's ip address is: "+ip);

        return ip;
    }
}
