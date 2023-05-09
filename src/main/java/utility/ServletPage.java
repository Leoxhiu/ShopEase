package utility;

public enum ServletPage {

    SIGN_UP("/shopease/guest/s/sign/up"),
    SIGN_IN("/shopease/guest/s/sign/in"),
    CODE_VERIFICATION("/shopease/guest/s/code/verification"),
    CUSTOMER_MARKET("/shopease/customer/s/market"),
    ;

    private final String url;

    ServletPage(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

}
