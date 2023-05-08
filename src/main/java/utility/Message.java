package utility;

public enum Message{

    // Failed
    PASSWORD_NOT_MATCH("Password does not match.", MessageType.ERROR),
    EMAIL_NOT_SEND("Something went wrong when sending email, please try again.", MessageType.ERROR),
    CODE_NOT_MATCH("The code provided is wrong, please try again.", MessageType.ERROR),
    REGISTRATION_FAILED("Registration failed.", MessageType.ERROR),
    LOGIN_FAILED("Login failed.", MessageType.ERROR),

    // Success
    REGISTRATION_SUCCESS("Registration successful.", MessageType.SUCCESS),
    LOGIN_SUCCESS("Login successful.", MessageType.SUCCESS),
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