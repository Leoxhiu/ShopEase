package utility;

public enum ButtonText {

    UNDERSTAND("Understand"),
    LOGIN_NOW("Login now");

    private final String text;

    ButtonText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
