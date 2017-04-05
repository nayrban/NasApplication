package nasapp.naz.com.nasapplication.comunication.model;

public enum GrantType {
    PASSWORD("password"), SOCIAL("social"),DIGITS("digits"), REFRESH_TOKEN("refresh_token");

    private String grantType;

    GrantType(String grantType) {
        this.grantType = grantType;
    }

    public String toString() {
        return this.grantType;
    }
}
