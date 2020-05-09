package com.library.smart_library.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;
import java.util.Set;
import org.apache.log4j.Logger;
/**
 * 登录拦截器
 */
public class LoginInterceptor implements HandlerInterceptor {

    private  Logger logger = Logger.getLogger(LoginInterceptor.class);
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

            logger.info("uri: " + request.getRequestURI());
//            Map map = request.getParameterMap();
//            if (map != null && !map.isEmpty()) {
//                Set<String> keySet = map.keySet();
//                for (String key : keySet) {
//                    String[] values = (String[]) map.get(key);
//                    for (String value : values) {
//                        logger.info("> " + key + "=" + value);
//                    }
//                }
//            }
//            HttpSession session = request.getSession();
//            logger.info(request.getSession().getAttribute("uid"));
           HttpSession session = request.getSession();
            if (session.getAttribute("uid") == null) {
                response.sendRedirect("/login");
                return false;
            }
            return true;
        }

}
