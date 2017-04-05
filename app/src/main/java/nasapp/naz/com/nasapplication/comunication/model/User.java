package nasapp.naz.com.nasapplication.comunication.model;

import com.fasterxml.jackson.annotation.JsonProperty;


public class User {
    @JsonProperty(value = "UserName")
    private String userName;

    @JsonProperty(value = "Password")
    private String password;

    @JsonProperty(value = "ConfirmPassword")
    private String confirmPassword;

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

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", confirmPassword='" + confirmPassword + '\'' +
                '}';
    }
}
