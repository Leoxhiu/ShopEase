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
    CUSTOMER_CART("/shopease/customer/s/cart"),
    CUSTOMER_PROFILE("/shopease/customer/s/profile"),
    CUSTOMER_WALLET("/shopease/customer/s/wallet"),
    CUSTOMER_TRANSACTION("/shopease/customer/s/transaction"),
    CUSTOMER_TRANSACTION_DETAIL("/shopease/customer/s/transaction/detail"),
    CUSTOMER_REVIEW("/shopease/customer/s/review"),
    CUSTOMER_REVIEW_DETAIL("/shopease/customer/s/review/detail"),

    // Seller
    SELLER_SIGN_UP("/shopease/guest/s/seller/sign/up"),
    SELLER_MARKET("/shopease/seller/s/market"),
    SELLER_PRODUCT_DETAIL("/shopease/seller/s/product/detail"),
    SELLER_DELETE_PRODUCT("/shopease/seller/s/delete/product"),
    SELLER_PUBLISH_PRODUCT("/shopease/seller/s/publish/product"),
    SELLER_PROFILE("/shopease/seller/s/profile"),
    SELLER_WALLET("/shopease/seller/s/wallet"),
    SELLER_TRANSACTION("/shopease/seller/s/transaction"),
    SELLER_REVIEW("/shopease/seller/s/review"),

    // Admin
    ADMIN_SIGN_IN("/shopease/s/auth/admin"),
    ADMIN_MEMBER_PAGE("/shopease/admin/s/member"),
    ADMIN_ADD_ADMIN("/shopease/admin/s/add/admin"),
    ADMIN_ADMIN_PROFILE("/shopease/admin/s/admin/profile"),
    ADMIN_DELETE_ADMIN("/shopease/admin/s/delete/admin"),
    ADMIN_SELLER_PROFILE("/shopease/admin/s/seller/profile"),
    ADMIN_DELETE_SELLER("/shopease/admin/s/delete/seller"),
    ADMIN_CUSTOMER_PROFILE("/shopease/admin/s/customer/profile"),
    ADMIN_DELETE_CUSTOMER("/shopease/admin/s/delete/customer"),

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
