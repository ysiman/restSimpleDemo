package ru.home.restSimpleDemo.config.webmvc;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import ru.home.restSimpleDemo.util.HttpRequestUtil;
import ru.home.restSimpleDemo.util.LoggingMDC;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Slf4j
public class RequestHeaderInterceptor implements HandlerInterceptor {
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        System.out.println("#run into RequestHeaderInterceptor!");
//        String rqUid = HttpRequestUtil.getRqUidFromHttpRequest(request);
//        LoggingMDC.addRqUidToMdc(rqUid);
//        return HandlerInterceptor.super.preHandle(request, response, handler);
//    }
//
//    @Override
//    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//        LoggingMDC.cleanMDC();
//        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
//    }
}
