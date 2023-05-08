package utility;

public enum JspPage {

    INDEX("/shopease/","/pages/index.jsp"),
    LANDING("/shopease/welcome","/pages/landing.jsp"),
    SIGN_IN("/shopease/sign/in","/pages/signIn.jsp"),
    SIGN_UP("/shopease/sign/up","/pages/signUp.jsp"),
    FORGOT_PASSWORD("/shopease/forgot/password","/pages/forgotPassword.jsp"),
    CODE_VERIFICATION("/shopease/code/verification","/pages/codeVerification.jsp"),
    RESET_PASSWORD("/shopease/reset/password","/pages/resetPassword.jsp"),
    HOME("/shopease/customer/home","/pages/customerHome.jsp"),
    MARKET("/shopease/customer/market","/pages/market.jsp")
    ;


    private final String url;
    private final String path;

    JspPage(String url, String path) {
        this.url = url;
        this.path = path;
    }

    public String getUrl() {
        return url;
    }

    public String getPath() {
        return path;
    }
}
