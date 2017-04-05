package nasapp.naz.com.nasapplication.comunication.factory;



public class ServiceConfiguration {
    private boolean useAuth;

    public ServiceConfiguration(boolean useAuth) {
        setUseAuth(useAuth);
    }

    public boolean isUseAuth() {
        return useAuth;
    }

    private void setUseAuth(boolean useAuth) {
        this.useAuth = useAuth;
    }

    public static class  ServiceConfigurationBuilder{
        private boolean useAuth;
        public ServiceConfigurationBuilder() {

        }
        public ServiceConfigurationBuilder useAuth(boolean useAuth){
            this.useAuth = useAuth;
            return this;
        }

        public ServiceConfiguration build(){
            return new ServiceConfiguration(useAuth);
        }

    }
}
