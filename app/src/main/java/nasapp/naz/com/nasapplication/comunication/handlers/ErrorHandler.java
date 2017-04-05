package nasapp.naz.com.nasapplication.comunication.handlers;



import java.io.IOException;
import java.lang.annotation.Annotation;

import nasapp.naz.com.nasapplication.comunication.factory.ServiceFactory;
import nasapp.naz.com.nasapplication.comunication.model.ErrorInfo;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Response;

public class ErrorHandler {

    public static ErrorInfo handleError(Response response) {
        Converter<ResponseBody, ErrorInfo> errorConverter =
                ServiceFactory.singleton().createRetroInstance(false).responseBodyConverter(ErrorInfo.class, new Annotation[0]);
        ErrorInfo errorInfo;
        try {
            errorInfo = errorConverter.convert(response.errorBody());
        } catch (IOException e) {
            e.printStackTrace();
            errorInfo = new ErrorInfo();
            errorInfo.setCode(response.code());
            errorInfo.setMessage(response.message());
            errorInfo.setUnhandlerError(true);
        }
        return errorInfo;
    }
}
