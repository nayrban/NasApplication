package nasapp.naz.com.nasapplication.comunication.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ErrorInfo implements Serializable {
    private Integer code;
    private String message;

    private boolean isUnhandlerError;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isUnhandlerError() {
        return isUnhandlerError;
    }

    public void setUnhandlerError(boolean unhandlerError) {
        isUnhandlerError = unhandlerError;
    }

    @Override
    public String toString() {
        return "ErrorInfo{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", isUnhandlerError=" + isUnhandlerError +
                '}';
    }
}
