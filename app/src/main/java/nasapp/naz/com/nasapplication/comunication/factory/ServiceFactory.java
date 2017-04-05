package nasapp.naz.com.nasapplication.comunication.factory;

import android.content.Context;
import android.text.TextUtils;

import java.io.IOException;

import nasapp.naz.com.nasapplication.comunication.interceptors.AuthInterceptor;
import nasapp.naz.com.nasapplication.comunication.model.AuthResponse;
import nasapp.naz.com.nasapplication.utils.AirbanqPreferencesInfo;
import nasapp.naz.com.nasapplication.utils.Constants;
import nasapp.naz.com.nasapplication.utils.JacksonMapper;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;
import rx.Scheduler;
import rx.schedulers.Schedulers;

public final class ServiceFactory {

    private static ServiceFactory singleton;
    private Scheduler defaultSubscribeScheduler;
    private OkHttpClient okHttpClient;
    private AuthResponse response;
    private AuthInterceptor authInterceptor;

    public static ServiceFactory init(Context context) {
        if (singleton == null) {
            synchronized (ServiceFactory.class) {
                if (singleton == null) {
                    setServiceFactory((new ServiceFactory(context)));
                }
            }
        }
        return singleton;
    }

    private static void setServiceFactory(ServiceFactory serviceFactory) {
        singleton = serviceFactory;
    }

    private ServiceFactory(Context context) {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        okHttpClient = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        AirbanqPreferencesInfo.getInstance(context);

        createAuthInterceptor();
    }

    private void createAuthInterceptor() {
        String authResponse = AirbanqPreferencesInfo.singleton().getPreference(Constants.AUTH_RESPONSE);
        if (!TextUtils.isEmpty(authResponse)) {
            try {
                this.response = JacksonMapper.mapToObject(AuthResponse.class, authResponse);
                this.authInterceptor = new AuthInterceptor(response.getAccessToken());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static ServiceFactory singleton() {
        if (singleton == null) {
            throw new IllegalStateException("Must Initialize ExceptionHandlerListener before using singleton()");
        } else {
            return singleton;
        }
    }

    public Scheduler defaultSubscribeScheduler() {
        if (defaultSubscribeScheduler == null) {
            defaultSubscribeScheduler = Schedulers.io();
        }
        return defaultSubscribeScheduler;
    }

    public Retrofit createRetroInstance(boolean useAuth) {
        return new Retrofit.Builder()
                .baseUrl(EndPoints.API_BASE_URL)
                .client(getOkHttpClient(useAuth))
                .addConverterFactory(JacksonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

    public <T> T createService(ServiceConfiguration serviceConfiguration, Class<T> serviceClass) {
        return createRetroInstance(serviceConfiguration.isUseAuth()).
                create(serviceClass);
    }

    public <T> T createService(Class<T> serviceClass) {
        return createService(new ServiceConfiguration.ServiceConfigurationBuilder().useAuth(false).build(), serviceClass);
    }

    public Retrofit createRetroWithToken() {
        return new Retrofit.Builder()
                .baseUrl(EndPoints.API_BASE_URL)
                .addConverterFactory(JacksonConverterFactory.create())
                // .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

    private OkHttpClient getOkHttpClient(boolean useAuth) {
        if (useAuth) {
            if(authInterceptor != null) {
                createAuthInterceptor();
            }

            if (authInterceptor != null && !okHttpClient.interceptors().contains(authInterceptor))
                okHttpClient.interceptors().add(authInterceptor);
        } else {
            if (okHttpClient.interceptors().contains(authInterceptor))
                okHttpClient.interceptors().remove(authInterceptor);
        }

        return okHttpClient;
    }

    private void checkTokenExpiration() {


    }

    public void saveAccessToken(AuthResponse response) {
        this.response = response;
        try {
            AirbanqPreferencesInfo.singleton().setPreference(Constants.AUTH_RESPONSE, JacksonMapper.mapToString(response));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
