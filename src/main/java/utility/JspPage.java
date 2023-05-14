package utility;

public enum JspPage {

    // Error pages
    PAGE_NOT_FOUND("/shopease/page/not/found","/pages/pageNotFound.jsp"),
    ACCESS_DENIED("/shopease/access/denied","/pages/accessDenied.jsp"),
    SERVER_ERROR("/shopease/server/error","/pages/serverError.jsp"),

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
    CUSTOMER_PRODUCT_DETAIL("/shopease/customer/product/detail","/pages/customerProductDetail.jsp"),
    CUSTOMER_CART("/shopease/customer/cart", "/pages/customerCart.jsp"),
    CUSTOMER_PROFILE("/shopease/customer/profile", "/pages/customerProfile.jsp"),
    CUSTOMER_WALLET("/shopease/customer/wallet", "/pages/customerWallet.jsp"),
    CUSTOMER_TRANSACTION("/shopease/customer/transaction", "/pages/customerTransaction.jsp"),
    CUSTOMER_TRANSACTION_DETAIL("/shopease/customer/transaction/detail", "/pages/customerTransactionDetail.jsp"),
    CUSTOMER_REVIEW("/shopease/customer/review", "/pages/customerReview.jsp"),
    CUSTOMER_REVIEW_DETAIL("/shopease/customer/review/detail", "/pages/customerReviewDetail.jsp"),

    // Seller pages
    SELLER_HOME("/shopease/seller/home", "/pages/sellerHome.jsp"),
    SELLER_PUBLISH_PRODUCT("/shopease/seller/publish/product","/pages/sellerPublishProduct.jsp"),
    SELLER_MARKET("/shopease/seller/market","/pages/sellerMarket.jsp"),
    SELLER_PRODUCT_DETAIL("/shopease/seller/product/detail","/pages/sellerProductDetail.jsp"),
    SELLER_PROFILE("/shopease/seller/profile", "/pages/sellerProfile.jsp"),
    SELLER_WALLET("/shopease/seller/wallet", "/pages/sellerWallet.jsp"),
    SELLER_SALES("/shopease/seller/sales","/pages/sellerSales.jsp"),
    SELLER_SALES_REVIEW("/shopease/seller/sales/review","/pages/sellerSalesReview.jsp"),

    // Admin pages
    ADMIN_SIGN_IN("/shopease/auth/admin","/pages/adminSignIn.jsp"),
    ADMIN_HOME("/shopease/admin/home", "/pages/adminHome.jsp"),
    ADMIN_MEMBER_PAGE("/shopease/admin/member", "/pages/adminMemberPage.jsp"),
    ADMIN_ADD_ADMIN("/shopease/admin/add/admin","/pages/adminAddAdmin.jsp"),
    ADMIN_ADMIN_PROFILE("/shopease/admin/admin/profile", "/pages/adminAdminProfile.jsp"),
    ADMIN_SELLER_PROFILE("/shopease/admin/seller/profile", "/pages/adminSellerProfile.jsp"),
    ADMIN_CUSTOMER_PROFILE("/shopease/admin/customer/profile", "/pages/adminCustomerProfile.jsp"),
    ADMIN_PROFILE("/shopease/admin/profile", "/pages/adminProfile.jsp"),
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
