package nasapp.naz.com.nasapplication.comunication.service;

import nasapp.naz.com.nasapplication.comunication.model.AuthResponse;
import nasapp.naz.com.nasapplication.comunication.model.User;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;


public interface UserService {
    @Headers({ "Content-Type: application/x-www-form-urlencoded", "Accept : application/json"})
    @FormUrlEncoded
    @POST("api/account/token")
    //TODO change this to call
    Call<AuthResponse> Login(@Field("grant_type") String grantType, @Field("username") String userName, @Field("password") String password);

    @POST("api/account/register")
        //TODO change this to call
    Call<Void> Register(@Body User userModel);
}
