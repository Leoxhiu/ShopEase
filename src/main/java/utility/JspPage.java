package utility;

public enum JspPage {

    // Error pages
    PAGE_NOT_FOUND("/shopease/page/not/found","/pages/pageNotFound.jsp"),
    ACCESS_DENIED("/shopease/access/denied","/pages/accessDenied.jsp"),

    // Guest pages
    INDEX("/shopease/","/pages/index.jsp"),
    LANDING("/shopease/guest/welcome","/pages/landing.jsp"),
    SIGN_IN("/shopease/guest/sign/in","/pages/signIn.jsp"),
    SIGN_UP("/shopease/guest/sign/up","/pages/signUp.jsp"),
    SELLER_SIGN_UP("/shopease/guest/join/as/seller","/pages/sellerSignUp.jsp"),
    FORGOT_PASSWORD("/shopease/guest/forgot/password","/pages/forgotPassword.jsp"),
    CODE_VERIFICATION("/shopease/guest/code/verification","/pages/codeVerification.jsp"),
    RESET_PASSWORD("/shopease/guest/reset/password","/pages/resetPassword.jsp"),

    // Customer pages
    CUSTOMER_HOME("/shopease/customer/home","/pages/customerHome.jsp"),
    MARKET("/shopease/customer/market","/pages/market.jsp"),

    // Seller pages
    SELLER_HOME("/shopease/seller/home", "/pages/sellerHome.jsp"),

    // Admin pages
    ADMIN_LOGIN("/shopease/auth/admin",""),
    ADMIN_HOME("/shopease/admin/home", "/pages/adminHome.jsp")
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
