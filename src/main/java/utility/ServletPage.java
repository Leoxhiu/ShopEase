package utility;

public enum ServletPage {

    // Guest
    SIGN_IN("/shopease/guest/s/sign/in"),
    FORGOT_PASSWORD("/shopease/guest/s/forgot/password"),
    RESET_PASSWORD("/shopease/guest/s/reset/password"),
    CODE_VERIFICATION("/shopease/guest/s/code/verification"),

    // Customer
    CUSTOMER_SIGN_UP("/shopease/guest/s/customer/sign/up"),
    CUSTOMER_MARKET("/shopease/customer/s/market"),

    // Seller
    SELLER_SIGN_UP("/shopease/guest/s/seller/sign/up"),

    // Admin
    ADMIN_SIGN_IN("/shopease/s/auth/admin")
    ;

    private final String url;

    ServletPage(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

}
