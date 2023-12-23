package com.skiapi.weatherapicommon.utility;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;

import java.util.logging.Logger;

@Slf4j
public class CommonUtility {

    public static String getIPAddress(HttpServletRequest request) {
        String ip = request.getHeader("X-FORWARED-FOR");

        if(ip == null || ip.isEmpty()){
            ip = request.getRemoteAddr();
        }
        log.info("Clients's ip address is: "+ip);

        return ip;
    }
}
