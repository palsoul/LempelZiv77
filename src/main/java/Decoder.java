import java.io.FileNotFoundException;

/**
 * @author: Brotherdos
 * @date: 06.10.2016.
 */
public class Decoder {
    public static void main(String[] args) {
        try {
            FileWorker.write("decoded.txt", decode(FileWorker.read("encoded.txt").split("\n")));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static String decode(String[] codes) {
        StringBuilder decoded = new StringBuilder();
        for (String code : codes) {
            String[] codeArray = code.split(",");
            if (codeArray[0].equals("0")) {
                decoded.append(codeArray[2]);
            } else {
                StringBuilder buffer = new StringBuilder();
                int offset = Integer.parseInt(codeArray[0]);
                int length = Integer.parseInt(codeArray[1]);
                int i = offset;

                while (length > 0) {
                    buffer.append(String.valueOf(decoded.charAt(decoded.length() - i)));
                    length--;
                    i--;
                    if (i <= 0) i = offset;
                }
                decoded.append(buffer);
                if (codeArray.length > 2) decoded.append(codeArray[2]);
            }
        }
        return decoded.toString();
    }
}
