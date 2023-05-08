package utility;

public enum JspPage {

    INDEX("/pages/index.jsp"),
    LANDING("/pages/landing.jsp"),
    SIGN_IN("/pages/signIn.jsp"),
    SIGN_UP("/pages/signUp.jsp"),
    FORGOT_PASSWORD("/pages/forgotPassword.jsp"),
    CODE_VERIFICATION("/pages/codeVerification.jsp"),
    RESET_PASSWORD("/pages/resetPassword.jsp"),
    HOME("/pages/customerHome.jsp"),
    MARKET("/pages/market.jsp")
    ;


    private final String url;

    JspPage(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
