import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatePassword {

    public static List<String> checkPassword(String password) {
        List<String> errorMessages = new ArrayList<>();

        if (password.length() < 8) {
            errorMessages.add("Password must be at least 8 characters");
        }

        Pattern digitPattern = Pattern.compile("(\\d)"); // Look for digits
        Matcher digitMatcher = digitPattern.matcher(password);
        int digitCount = 0;
        while (digitMatcher.find()) {
            digitCount++;
        }
        if (digitCount < 2) {
            errorMessages.add("The password must contain at least 2 numbers");
        }

        Pattern capitalLetterPattern = Pattern.compile("([A-Z])"); // Look for capital letters
        Matcher capitalLetterMatcher = capitalLetterPattern.matcher(password);
        if (!capitalLetterMatcher.find()) {
            errorMessages.add("Password must contain at least one capital letter");
        }

        Pattern specialCharacterPattern = Pattern.compile("([!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?])"); // Look for special characters
        Matcher specialCharacterMatcher = specialCharacterPattern.matcher(password);
        if (!specialCharacterMatcher.find()) {
            errorMessages.add("Password must contain at least one special character");
        }

        return errorMessages;
    }
}
