package utility;

import jakarta.servlet.http.HttpServletRequest;

public class MessageHandler {

    public static void setMessage(HttpServletRequest request, Message message, ButtonText buttonText, String url) {
        switch (message.getType()) {
            case SUCCESS -> {
                request.setAttribute("successMessage", message.getMessage());
                request.setAttribute("url", url);
            }
            case ERROR -> request.setAttribute("errorMessage", message.getMessage());
            default -> {
            }
        }
        request.setAttribute("buttonText", buttonText.getText());
    }

    public static void setCustomSuccessMessage(HttpServletRequest request, String message, ButtonText buttonText, String url) {

        request.setAttribute("successMessage", message);
        request.setAttribute("url", url);
        request.setAttribute("buttonText", buttonText.getText());
    }

    public static void setCustomErrorMessage(HttpServletRequest request, String message, ButtonText buttonText) {

        request.setAttribute("errorMessage",message);
        request.setAttribute("buttonText", buttonText.getText());
    }

    public static void setCustomLinkErrorMessage(HttpServletRequest request, String message, ButtonText buttonText, String url) {

        request.setAttribute("linkErrorMessage",message);
        request.setAttribute("url", url);
        request.setAttribute("buttonText", buttonText.getText());
    }
}
