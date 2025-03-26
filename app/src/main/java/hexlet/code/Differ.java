package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Differ {

    public static String generate(String filePath1, String filePath2) throws Exception {
        // Читаем и парсим JSON файлы
        Map<String, Object> data1 = readJsonFile(filePath1);
        Map<String, Object> data2 = readJsonFile(filePath2);

        // Получаем уникальные ключи из обоих файлов и сортируем их
        Set<String> allKeys = new TreeSet<>(data1.keySet());
        allKeys.addAll(data2.keySet());

        // Формируем строку с различиями
        StringBuilder result = new StringBuilder("{\n");

        for (String key : allKeys) {
            if (data1.containsKey(key) && !data2.containsKey(key)) {
                result.append("  - ").append(key).append(": ").append(data1.get(key)).append("\n");
            } else if (!data1.containsKey(key) && data2.containsKey(key)) {
                result.append("  + ").append(key).append(": ").append(data2.get(key)).append("\n");
            } else if (!Objects.equals(data1.get(key), data2.get(key))) {
                result.append("  - ").append(key).append(": ").append(data1.get(key)).append("\n");
                result.append("  + ").append(key).append(": ").append(data2.get(key)).append("\n");
            } else {
                result.append("    ").append(key).append(": ").append(data1.get(key)).append("\n");
            }
        }

        result.append("}");
        return result.toString();
    }

    private static Map<String, Object> readJsonFile(String filePath) throws Exception {
        // Читаем содержимое файла в строку
        String content = new String(Files.readAllBytes(Paths.get(filePath)));
        // Парсим JSON в Map с помощью Jackson
        return new ObjectMapper().readValue(content, Map.class);
    }
}
