package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Differ {

    public static String generate(String filePath1, String filePath2) throws Exception {
        ObjectMapper mapper = new ObjectMapper();

        Map<String, Object> map1 = mapper.readValue(Files.readString(Paths.get(filePath1)), Map.class);
        Map<String, Object> map2 = mapper.readValue(Files.readString(Paths.get(filePath2)), Map.class);

        Set<String> allKeys = new TreeSet<>();
        allKeys.addAll(map1.keySet());
        allKeys.addAll(map2.keySet());

        StringBuilder result = new StringBuilder();
        result.append("{\n");

        for (String key : allKeys) {
            boolean in1 = map1.containsKey(key);
            boolean in2 = map2.containsKey(key);
            Object val1 = map1.get(key);
            Object val2 = map2.get(key);

            if (in1 && in2) {
                if (Objects.equals(val1, val2)) {
                    result.append("    ").append(key).append(": ").append(val1).append("\n");
                } else {
                    result.append("  - ").append(key).append(": ").append(val1).append("\n");
                    result.append("  + ").append(key).append(": ").append(val2).append("\n");
                }
            } else if (in1) {
                result.append("  - ").append(key).append(": ").append(val1).append("\n");
            } else {
                result.append("  + ").append(key).append(": ").append(val2).append("\n");
            }
        }

        result.append("}");
        return result.toString();
    }
}
