package utility;

import java.util.Random;

public class RandomCode {

    private static String code = "";

    private RandomCode(){

    }

    public static String GENERATE(){
        String candidates =  "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        int length = 7;

        StringBuilder random_code = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            random_code.append(candidates.charAt(random.nextInt(candidates.length())));
        }

        return random_code.toString();
    }
}
