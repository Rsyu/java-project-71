import com.fasterxml.jackson.databind.ObjectMapper;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class Parser {
    // Чтение файла и возврат содержимого
    public static String readFile(String filePath) throws Exception {
        Path path = Paths.get(filePath).toAbsolutePath().normalize();
        return Files.readString(path);
    }

    // Парсинг JSON-строки в Map
    public static Map<String, Object> parseJson(String content) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(content, Map.class);
    }

    // Точка входа программы
    public static void main(String[] args) throws Exception {
        String file1 = "file1.json";
        String file2 = "file2.json";

        String content1 = readFile(file1);
        String content2 = readFile(file2);

        Map<String, Object> data1 = parseJson(content1);
        Map<String, Object> data2 = parseJson(content2);

        System.out.println("File1 data: " + data1);
        System.out.println("File2 data: " + data2);
    }
}