import java.util.List;

class Main {
        public static void main(String[] args) {
            String password = "Some+";
            List<String> errorMessages = ValidatePassword.checkPassword(password);
            for (String message : errorMessages) {
                System.out.println(message);
            }
        }
    }
