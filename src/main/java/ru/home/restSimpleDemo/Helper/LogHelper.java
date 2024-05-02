package ru.home.restSimpleDemo.Helper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LogHelper {
    static ObjectWriter ow;

    static {
        ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
    }

    public static String objectToJson(Object object){
//         ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = null;
        try {
            json = ow.writeValueAsString(object);
        } catch (JsonProcessingException e) {
           log.error("Ошибка преобразования объекта в строку");
        }
        return json;
    }
}
