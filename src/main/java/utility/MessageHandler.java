package utility;

import jakarta.servlet.http.HttpServletRequest;

public class MessageHandler {

    public static void setMessage(HttpServletRequest request, Message message, ButtonText buttonText, String url) {
        switch (message.getType()) {
            case SUCCESS:
                request.setAttribute("successMessage", message.getMessage());
                request.setAttribute("url", url);
                break;
            case ERROR:
                request.setAttribute("errorMessage", message.getMessage());
                break;
            default:
                break;
        }
        request.setAttribute("buttonText", buttonText.getText());
    }

}
