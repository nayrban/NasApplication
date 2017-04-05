package nasapp.naz.com.nasapplication.comunication.api.calls;

import nasapp.naz.com.nasapplication.comunication.factory.ServiceFactory;
import retrofit2.Callback;

public abstract class ServiceCaller<T, C> {

    public abstract ServiceCaller prepare(T request);

    public abstract  void doCall(Callback<C> callback);

    protected <K> K createCaller(Class<K> serviceClass){
        return ServiceFactory.singleton().
                createService(serviceClass);
    }
}
