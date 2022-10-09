import java.lang.*;

public class CheckPassword {
    public static boolean longEnough(String password) {
        if (password.length() < 12) {
            return false;
        }
        return true;
    }

    public static boolean atLeastTwoDigits(String password) {
        int count;
        count = 0;
        int i;
        i = 0;
        while (count < password.length()) {
            char character;
            character = password.charAt(count);
            if (Character.isDigit(character) == true) {
                i += 1;
            }
            count += 1;
        }

        if (i >= 2) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        int lengthOfArgs;
        lengthOfArgs = args.length;

        if (lengthOfArgs == 0) {
            System.err.print("Usage: java CheckPassword <password>");
            System.exit(1);
        } else if (longEnough(args[0]) == false) {
            System.out.print("Password is not valid");
            System.exit(1);
        } else if (atLeastTwoDigits(args[0]) == false) {
            System.out.print("Password is not valid");
            System.exit(1);
        } else {
            System.out.println("Password is valid");
        }
    }
}
