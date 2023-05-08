package utility;

public enum EmailSubject {
    REGISTRATION("Registration Confirmation"),
    PASSWORD_RESET("Account Recovery"),
    AUTHENTICATION("2 Factor Authentication");

    private final String subject;

    EmailSubject(String subject) {
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }
}
