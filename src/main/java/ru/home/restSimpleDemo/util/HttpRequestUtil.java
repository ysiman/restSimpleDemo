package ru.home.restSimpleDemo.util;

import lombok.extern.slf4j.Slf4j;
import org.owasp.encoder.Encode;


import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

@Slf4j
public class HttpRequestUtil {
    private static final String RQ_UID_HEADER = "rqUid";
    private static final String RQ_TM_HEADER = "rqTm";
    public static String getRqUidFromHttpRequest(HttpServletRequest request){
        String rqUid = UUID.randomUUID().toString();
        String rqUidIhHeader = Encode.forHtml(request.getHeader(RQ_UID_HEADER));
        if (rqUidIhHeader == null){
            log.warn("Не удалось получить rqUid из запроса, генерируем свой {}", rqUid);
            return rqUid;
        }
        try {
            rqUid = UUID.fromString(rqUidIhHeader).toString();

        } catch (IllegalArgumentException ex){
            log.warn("Не удалось преобразовать rqUid из запроса - {}, генерируем свой {}", rqUidIhHeader,  rqUid);
        }
        return rqUid;
    }
}
