// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.util.Scanner;


public class PasswordChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите пароль: ");
        String password = scanner.nextLine();
        if (validatePassword(password)) {
            System.out.println("Пароль надежный");
        } else {
            System.out.println("Пароль ненадежный");
            System.out.println("Сгенерированный надежный пароль: " + generatePassword());
        }
    }

    private static boolean validatePassword(String password) {
        if (password.length() < 8) {
            return false;
        }

        boolean hasUpperCase = false;
        boolean hasLowerCase = false;
        boolean hasNumber = false;
        boolean hasSymbol = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUpperCase = true;
            } else if (Character.isLowerCase(c)) {
                hasLowerCase = true;
            } else if (Character.isDigit(c)) {
                hasNumber = true;
            } else if ("!@#$%^&*()_+-=[]{}|;':\"\\,./<>?".indexOf(c) != -1) {
                hasSymbol = true;
            }
        }

        return hasUpperCase && hasLowerCase && hasNumber && hasSymbol;
    }

    private static String generatePassword() {
        String password = "";
        while (!validatePassword(password)) {
            password = PasswordGenerator.generatePassword();
        }
        return password;
    }
}