package utility;

public enum ServletPage {

    // Guest
    SIGN_IN("/shopease/guest/s/sign/in"),
    FORGOT_PASSWORD("/shopease/guest/s/forgot/password"),
    RESET_PASSWORD("/shopease/guest/s/reset/password"),
    CODE_VERIFICATION("/shopease/guest/s/code/verification"),
    SIGN_OUT("/shopease/s/sign/out"),

    // Customer
    CUSTOMER_SIGN_UP("/shopease/guest/s/customer/sign/up"),
    CUSTOMER_MARKET("/shopease/customer/s/market"),
    CUSTOMER_PRODUCT_DETAIL("/shopease/customer/s/product/detail"),
    CUSTOMER_PROFILE("/shopease/customer/s/profile"),

    // Seller
    SELLER_SIGN_UP("/shopease/guest/s/seller/sign/up"),
    SELLER_MARKET("/shopease/seller/s/market"),
    SELLER_PRODUCT_DETAIL("/shopease/seller/s/product/detail"),
    SELLER_DELETE_PRODUCT("/shopease/seller/s/delete/product"),
    SELLER_PROFILE("/shopease/seller/s/profile"),
    SELLER_PUBLISH_PRODUCT("/shopease/seller/s/publish/product"),

    // Admin
    ADMIN_SIGN_IN("/shopease/s/auth/admin"),
    ADMIN_MEMBER_PAGE("/shopease/admin/s/member"),
    ADMIN_PROFILE("/shopease/admin/s/profile"),
    ;

    private final String url;

    ServletPage(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

}
