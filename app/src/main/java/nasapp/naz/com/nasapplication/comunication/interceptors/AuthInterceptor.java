package nasapp.naz.com.nasapplication.comunication.interceptors;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;


public class AuthInterceptor implements Interceptor {
    private String accessToken;

    public AuthInterceptor(String accessToken) {
        this.accessToken = accessToken;
    }

    public void updateAccessToken(String accessToken){
        this.accessToken = accessToken;
    }
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request newRequest = chain.request().newBuilder().addHeader("Authorization", "Bearer"
                + accessToken).build();
        return chain.proceed(newRequest);

    }
}

