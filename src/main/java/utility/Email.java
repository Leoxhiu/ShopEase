package utility;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Email {

    private static final String shopease_email = "aspire.com.my@gmail.com";
    private static final String shopease_password = "Aspire123";

    private Email(){

    }

    public static String get_front(String email){
        Pattern pattern = Pattern.compile("^(.*?)@");
        Matcher matcher = pattern.matcher(email);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return email;
    }

    public static void send(){

    }
}
