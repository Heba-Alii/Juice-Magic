package eg.gov.iti.juicemagic.pojo;

import java.io.Serializable;

public class UsersModel implements Serializable {
    private String client_name;
    private String client_phone;
    private String client_password;
    private String client_email;
    private String device_token;
    private String lang;
    private String type;

    public String getClient_name() {
        return client_name;
    }

    public void setClient_name(String client_name) {
        this.client_name = client_name;
    }

    public String getClient_phone() {
        return client_phone;
    }

    public void setClient_phone(String client_phone) {
        this.client_phone = client_phone;
    }

    public String getClient_password() {
        return client_password;
    }

    public void setClient_password(String client_password) {
        this.client_password = client_password;
    }

    public String getClient_email() {
        return client_email;
    }

    public void setClient_email(String client_email) {
        this.client_email = client_email;
    }

    public String getDevice_token() {
        return device_token;
    }

    public void setDevice_token(String device_token) {
        this.device_token = device_token;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public UsersModel(String client_name, String client_phone, String client_password, String client_email, String device_token, String lang, String type) {
        this.client_name = client_name;
        this.client_phone = client_phone;
        this.client_password = client_password;
        this.client_email = client_email;
        this.device_token = device_token;
        this.lang = lang;
        this.type = type;

    }
}
