package consoleapp;

import java.util.regex.Pattern;

public class Validation {
    /**
     * phone number validation using regex
     * @param phoneNumber - String
     * @return boolean
     */
    public static boolean validatePhoneNumber(String phoneNumber){
        return Pattern
                .compile("(0/91)?[7-9][0-9]{9}")
                .matcher(phoneNumber)
                .matches();
    }

    /**
     * email validation using regex
     * @param email - String
     * @return boolean
     */
    public static boolean validateEmailId(String email){
        return Pattern
                .compile("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\\\.[A-Za-z0-9-]+)*(\\\\.[A-Za-z]{2,})$")
                .matcher(email)
                .matches();
    }

    /**
     * amount validation using regex
     * @param amount - float
     * @return boolean
     */
    public static boolean validateAmount(float amount){
        return amount>=0;
    }
}
