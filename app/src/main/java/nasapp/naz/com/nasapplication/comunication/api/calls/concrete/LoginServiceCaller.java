package nasapp.naz.com.nasapplication.comunication.api.calls.concrete;

import nasapp.naz.com.nasapplication.comunication.api.calls.ServiceCaller;
import nasapp.naz.com.nasapplication.comunication.model.AuthRequest;
import nasapp.naz.com.nasapplication.comunication.model.AuthResponse;
import nasapp.naz.com.nasapplication.comunication.model.GrantType;
import nasapp.naz.com.nasapplication.comunication.service.UserService;
import retrofit2.Callback;

public class LoginServiceCaller extends ServiceCaller<AuthRequest, AuthResponse> {

    private AuthRequest authRequest;

    @Override
    public  LoginServiceCaller prepare(AuthRequest request) {
        authRequest = request;
        return this;
    }

    @Override
    public void doCall(Callback<AuthResponse> callback) {
        createCaller(UserService.class).
                Login(GrantType.PASSWORD.toString(),
                        authRequest.getUserName(),
                        authRequest.getPassword()).
                enqueue(callback);
    }
}
