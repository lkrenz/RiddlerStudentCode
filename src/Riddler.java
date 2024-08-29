import java.sql.Array;
import java.util.ArrayList;

/**
 * The Riddler:
 * A puzzle by Zach Blick
 * for Adventures in Algorithms
 * At Menlo School in Atherton, CA
 *
 * Completed by: Liam Krenz
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
                newText = (char) (((newText - 56) % 26) + 65);
            } else if (i >= 97 && i <= 122) {
                newText = (char) (((newText - 88) % 26) + 97);
            }
            decrypted += newText;
        }
        System.out.println(decrypted);
        return decrypted;
    }

    public String decryptTwo(String encrypted) {
        String decrypted = "";

        // Split the paragraph into an array of strings.
        String[] newText = encrypted.split(" ");

        // Iterate through the paragraph and convert each askii value to plaintext.
        for (String i : newText) {
            int integerValue = Integer.parseInt(i);
            decrypted += (char) integerValue;
        }
        System.out.println(decrypted);
        return decrypted;
    }

    public String decryptThree(String encrypted) {
        String decrypted = "";

        // Iterate through the binary paragraph by eight character chunks, converting each into plain text.
        for (int i = 0; i < encrypted.length(); i += 8) {
            String numbers = encrypted.substring(i, i+8);
            int decimal = toInt(numbers);
            decrypted += (char) decimal;
        }
        System.out.println(decrypted);
        return decrypted;
    }

    // Converts an eight bit binary input into its decimal value.
    public int toInt(String numbers) {
        int total = 0;
        int length = numbers.length();

        // Iterates through each digit, starting with the first an multiplying by two each time.
        for (int i = 0; i < length - 1; i++) {
            total += numbers.charAt(i) - '0';
            total *= 2;
        }

        // Adds the final digit without multiplying and returns.
        total += numbers.charAt(length - 1) - '0';
        return total;
    }

    public String decryptFour(String encrypted) {
        String decrypted = "";

        // Convert the emojis into their Unicode decimal number then convert into askii range.
        for (int i = 0; i < encrypted.length(); i++) {
            int unicode = encrypted.codePointAt(i);
            decrypted += (char) (unicode - 9951 + 32);
        }
        System.out.println(decrypted);
        return decrypted;
    }
}
