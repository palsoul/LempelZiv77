import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author: Bauka23
 * @date: 04.10.2016
 */
public class Encoder {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String text;
        try {
            text = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            text = "";
        }
        FileWorker.write("encoded.txt", encode(text));
    }

    private static String encode(String text) {
        StringBuilder encodedText = new StringBuilder();
        StringBuilder buffer = new StringBuilder();

        int i = 0;
        while (i < text.length()) {
            int offset = 0, length = 0, j = 1;
            while (j <= buffer.length()) {
                while (text.charAt(i) == buffer.charAt(buffer.length() - j)) {
                    offset = j;
                    length++;
                    i++;
                    if (buffer.length() - j < 0) {
                        j--;
                    }
                }
            }
            encodedText.append(offset + "," + length + "," + text.charAt(i) + "\n");
        }

        return encodedText.toString();
    }
}
