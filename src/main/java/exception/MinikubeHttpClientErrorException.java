package exception;

import org.springframework.http.HttpStatusCode;

public class MinikubeHttpClientErrorException extends BaseHttpClientErrorException {


    public MinikubeHttpClientErrorException(HttpStatusCode httpStatus, String statusDesc) {
        super(httpStatus, statusDesc);
    }
}
