package utility;

public enum Message{

    // ACCOUNT ERROR
    ACCOUNT_EXIST("Email exists",MessageType.ERROR),
    ACCOUNT_NOT_EXIST("Email does not exist", MessageType.ERROR),
    ACCOUNT_NOT_APPROVED("Your account is not approved yet, it will take 5-7 working days.", MessageType.ERROR),
    BANK_ACCOUNT_INVALID("Invalid bank account, please try again.", MessageType.ERROR),
    NAME_LENGTH_INVALID("Name should have a minimum length of 2 characters.", MessageType.ERROR),
    PASSWORD_LENGTH_INVALID("Password should have a minimum length of 8 characters.", MessageType.ERROR),
    PASSWORD_NOT_MATCH("Password does not match", MessageType.ERROR),
    EMAIL_NOT_SEND("Something went wrong when sending email, please try again.", MessageType.ERROR),
    CODE_NOT_MATCH("The code provided is wrong, please try again.", MessageType.ERROR),
    SIGN_UP_FAILED("Sign up failed", MessageType.ERROR),
    SIGN_IN_FAILED("Sign in failed", MessageType.ERROR),
    RESET_PASSWORD_FAILED("Reset password failed, please try again", MessageType.ERROR),
    UPDATE_FAILED("Update failed, please try again.", MessageType.ERROR),
    BANK_ACCOUNT_BLANK("You are unable to publish product without a bank account, kindly go to your profile to set it up.", MessageType.ERROR),
    ADDRESS_BLANK("Please complete your address under profile to proceed with your action", MessageType.ERROR),

    // PRODUCT ERROR
    PRODUCT_NAME_LENGTH_INVALID("Product name should in between 2 and 100 characters.", MessageType.ERROR),
    PRODUCT_DESCRIPTION_LENGTH_INVALID("Product description should have a minimum length of 10 characters.", MessageType.ERROR),
    PRODUCT_PRICE_INVALID("Please insert valid product price.", MessageType.ERROR),
    PRODUCT_QUANTITY_INVALID("Please insert valid product quantity.", MessageType.ERROR),
    PRODUCT_DISCOUNT_INVALID("Product discount should in between 0% - 95%", MessageType.ERROR),
    PRODUCT_PUBLISH_FAILED("Product failed to be published, please try again.", MessageType.ERROR),

    // ACCOUNT SUCCESS
    SIGN_UP_SUCCESS("Sign up successful", MessageType.SUCCESS),
    SELLER_SIGN_UP_SUCCESS("Sign up successful, you will be able to login after obtaining approval from admin (5-7 working days).", MessageType.SUCCESS),
    SIGN_IN_SUCCESS("Sign in successful", MessageType.SUCCESS),
    RESET_PASSWORD_SUCCESS("Reset password successful", MessageType.SUCCESS),
    UPDATE_SUCCESS("Update successful", MessageType.SUCCESS),

    // PRODUCT SUCCESS
    PRODUCT_PUBLISH_SUCCESS("Product publish successful", MessageType.SUCCESS),
    ;

    private final String message;
    private final MessageType type;

    Message(String message, MessageType type) {
        this.message = message;
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public MessageType getType() {
        return type;
    }
}