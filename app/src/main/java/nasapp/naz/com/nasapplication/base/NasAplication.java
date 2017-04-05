package nasapp.naz.com.nasapplication.base;

import android.app.Application;

import nasapp.naz.com.nasapplication.comunication.factory.ServiceFactory;
import nasapp.naz.com.nasapplication.utils.tools.ereza.ExceptionHandlerListener;

/**
 * Created by Bryan on 30/03/2017.
 */

public class NasAplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ServiceFactory.init(this);
        ExceptionHandlerListener.init(this);
    }
}
