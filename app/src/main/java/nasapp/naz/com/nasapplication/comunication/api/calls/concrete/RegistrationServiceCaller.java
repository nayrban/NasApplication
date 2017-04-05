package nasapp.naz.com.nasapplication.comunication.api.calls.concrete;

import nasapp.naz.com.nasapplication.comunication.api.calls.ServiceCaller;
import nasapp.naz.com.nasapplication.comunication.model.AuthRequest;
import nasapp.naz.com.nasapplication.comunication.model.AuthResponse;
import nasapp.naz.com.nasapplication.comunication.model.GrantType;
import nasapp.naz.com.nasapplication.comunication.model.User;
import nasapp.naz.com.nasapplication.comunication.service.UserService;
import retrofit2.Callback;

public class RegistrationServiceCaller extends ServiceCaller<User, Void> {

    private User user;

    @Override
    public RegistrationServiceCaller prepare(User request) {
        user = request;
        return this;
    }

    @Override
    public void doCall(Callback<Void> callback) {
        createCaller(UserService.class).
                Register(user).
                enqueue(callback);
    }
}
