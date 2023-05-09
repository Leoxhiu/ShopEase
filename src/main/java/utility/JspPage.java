package utility;

public enum JspPage {

    // Error pages
    PAGE_NOT_FOUND("/shopease/page/not/found","/pages/pageNotFound.jsp"),
    ACCESS_DENIED("/shopease/access/denied","/pages/accessDenied.jsp"),

    // Guest pages
    INDEX("/shopease/","/pages/index.jsp"),
    LANDING("/shopease/guest/welcome","/pages/landing.jsp"),
    SIGN_IN("/shopease/guest/sign/in","/pages/signIn.jsp"),
    CUSTOMER_SIGN_UP("/shopease/guest/customer/sign/up","/pages/customerSignUp.jsp"),
    SELLER_SIGN_UP("/shopease/guest/seller/sign/up","/pages/sellerSignUp.jsp"),
    FORGOT_PASSWORD("/shopease/guest/forgot/password","/pages/forgotPassword.jsp"),
    CODE_VERIFICATION("/shopease/guest/code/verification","/pages/codeVerification.jsp"),
    RESET_PASSWORD("/shopease/guest/reset/password","/pages/resetPassword.jsp"),

    // Customer pages
    CUSTOMER_HOME("/shopease/customer/home","/pages/customerHome.jsp"),
    CUSTOMER_MARKET("/shopease/customer/market","/pages/customerMarket.jsp"),
    CUSTOMER_PRODUCT_DETAIL("/shopease/customer/product/detail/comments","/pages/customerProductDetail.jsp"),

    // Seller pages
    SELLER_HOME("/shopease/seller/home", "/pages/sellerHome.jsp"),
    SELLER_MARKET("/shopease/seller/market","pages/sellerMarket.jsp"),
    SELLER_PRODUCT_DETAIL("/shopease/seller/product/detail/comments","/pages/sellerProductDetail.jsp"),

    // Admin pages
    ADMIN_SIGN_IN("/shopease/auth/admin","/pages/adminSignIn.jsp"),
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
