package nasapp.naz.com.nasapplication.comunication.api.calls;

import android.util.Log;

import nasapp.naz.com.nasapplication.comunication.handlers.ErrorHandler;
import nasapp.naz.com.nasapplication.comunication.model.ErrorInfo;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public abstract class RetroCallback<T> implements Callback<T> {

    @Override
    public final void onResponse(Call<T> call, Response<T> response) {
        if (!response.isSuccessful()) {
            onError(parseError(response));
        }else {
            onSuccess(response.body());
        }
    }

    public abstract void onSuccess(T response);

    public abstract void onError(ErrorInfo errorInfo);

    @Override
    public final void onFailure(Call<T> call, Throwable t) {
        //TODO send to a log
        Log.v("TAG", "failure");
    }

    private ErrorInfo parseError(Response<T> response){
        return  ErrorHandler.handleError(response);
    }
}
