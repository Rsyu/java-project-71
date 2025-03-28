package hexlet.code;

import java.io.IOException;
import java.util.Map;

public class Differ {
    public static String generate(String filePath1, String filePath2) throws IOException {
        Map<String, Object> data1 = Parser.parse(filePath1);
        Map<String, Object> data2 = Parser.parse(filePath2);

        return Formatter.format(data1, data2);
    }
}
