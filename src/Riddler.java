import java.sql.Array;
import java.util.ArrayList;

/**
 * The Riddler:
 * A puzzle by Zach Blick
 * for Adventures in Algorithms
 * At Menlo School in Atherton, CA
 *
 * Completed by: YOUR NAME HERE
 */
public class Riddler {

    public String decryptOne(String encrypted) {
        String decrypted = "";

        // Convert the inputted string into an array of chars to use enhanced for loop
        char[] encryptedArray = encrypted.toCharArray();

        // Use the askii values of each character to shift the value by 9
        for (char i : encryptedArray) {
            char newText = i;
            // Use two separate cases for uppercase and lowercase
            if (i <= 90 && i >= 65) {
                newText += 9;
                if (newText > 90)
                    newText -= 26;
            } else if (i >= 97 && i <= 122) {
                newText += 9;
                if (newText > 122)
                    newText -= 26;
            }
            decrypted += newText;
        }

        return decrypted;
    }

    public String decryptTwo(String encrypted) {
        String decrypted = "";

        // TODO: Complete the decryptTwo() function.
        String[] newText = encrypted.split(" ", 0);
        for (String i : newText) {
            int integerValue = Integer.parseInt(i);
            char letter = (char) integerValue;
            decrypted += letter;
        }
        return decrypted;
    }

    public String decryptThree(String encrypted) {
        String decrypted = "";

        // TODO: Complete the decryptThree() function.
        for (int i = 0; i + 8 < encrypted.length(); i += 8) {
            String numbers = encrypted.substring(i, i+8);
            int decimal = Integer.parseInt(numbers, 2);
            decrypted += (char) decimal;
        }


        return decrypted;
    }

    public String decryptFour(String encrypted) {
        String decrypted = "";

        // TODO: Complete the decryptFour() function.

        return decrypted;
    }
}
