package nasapp.naz.com.nasapplication.comunication.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;


public class AuthRequest implements Serializable{

    @JsonProperty(value = "grant_type")
    private GrantType grantType;

    @JsonProperty(value = "username")
    private String userName;

    private String password;

    public String getGrantType() {
        return grantType.toString();
    }

    public void setGrantType(GrantType grantType) {
        this.grantType = grantType;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "AuthRequest{" +
                "grantType=" + grantType.toString() +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

