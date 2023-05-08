package utility;

public enum ServletPage {

    SIGN_UP("/shopease/s/sign-up"),
    CODE_VERIFICATION("/shopease/s/code-verification"),

    ;

    private final String url;

    ServletPage(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

}
