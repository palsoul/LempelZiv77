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
        StringBuilder addedText = new StringBuilder();
        String buffer;

        int i = 0;
        while (i < text.length()) {
            buffer = getBuffer(text, i, addedText);
        }
    }

    private static String getBuffer(String text, int i, StringBuilder addedText) {
        int j = 1;
        int offset = 0;
        int length = 0;
        while (j <= addedText.length()) {

        }
        if (offset > 0) {
            return buildBuffer(text, i, offset, length);
        } else {
            return String.valueOf(text.charAt(i));
        }
    }

    private static String buildBuffer(String text, int i, int offset, int length) {
        StringBuilder buffer = new StringBuilder();
        int k = offset;
        while (length > 0) {
            // TODO реализовать этот метод
            buffer.append(String.valueOf(text.charAt(k)));
        }
        return null;
    }
}
