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

        int i = 0;
        while (i < text.length()) {
            int offset = 0, length = 0;
            int tmpOffset = 0, tmpLength = 0;
            int j = 1;
            while (j <= i && i < text.length()) {
                if (text.charAt(i - j) == text.charAt(i)) {
                    tmpOffset = j;
                    tmpLength = getLength(text, i, j);
                    if (tmpLength > length) {
                        offset = tmpOffset;
                        length = tmpLength;
                    }
                }
                j++;
            }
            i += length;
            if (offset > 0) {
                encodedText.append(offset).append(",").append(length).append(",");
                if (i < text.length()) encodedText.append(String.valueOf(text.charAt(i)));
                encodedText.append("\n");
            } else {
                encodedText.append(0).append(",").append(0).append(",").append(String.valueOf(text.charAt(i))).append("\n");
            }
            if (i < text.length())
            i++;
        }
        return encodedText.toString();
    }

    private static int getLength(String text, int i, int offset) {
        int length = 0;
        int j = offset;
        while (text.charAt(i + length) == text.charAt(i - j)) {
            length++;
            j--;
            if (j == 0) j = offset;
            if (i + length >= text.length()) break;
        }
        return length;
    }
}
