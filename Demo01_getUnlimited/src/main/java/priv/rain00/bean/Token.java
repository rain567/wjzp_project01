package priv.rain00.bean;

public class Token {

    private String appid;
    private String secret;

    @Override
    public String toString() {
        return "Token{" +
                "appid='" + appid + '\'' +
                ", secret='" + secret + '\'' +
                '}';
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }
}
