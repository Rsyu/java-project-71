package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;
import picocli.CommandLine.Command;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

@Command(name = "gendiff", description = "Compares two configuration files and shows a difference.")
public class App implements Runnable {

    @Parameters(index = "0", description = "path to first file")
    private String filepath1;

    @Parameters(index = "1", description = "path to second file")
    private String filepath2;

    @Option(names = {"-f", "--format"}, description = "output format [default: stylish]", defaultValue = "stylish")
    private String format;

    @Option(names = {"-h", "--help"}, description = "Show this help message and exit.", help = true)
    private boolean helpRequested;

    @Option(names = {"-V", "--version"}, description = "Print version information and exit.")
    private boolean versionRequested;

    @Override
    public void run() {
        if (helpRequested) {
            CommandLine.usage(this, System.out);
        } else if (versionRequested) {
            System.out.println("gendiff version 1.0");
        } else {
            try {
                // Чтение и парсинг файлов
                Map<String, Object> file1Data = readFileAndParse(filepath1);
                Map<String, Object> file2Data = readFileAndParse(filepath2);

                // Вывод сравнения
                System.out.println("Comparing files: " + filepath1 + " and " + filepath2);
                System.out.println("Output format: " + format);
                System.out.println("File 1 data: " + file1Data);
                System.out.println("File 2 data: " + file2Data);

            } catch (Exception e) {
                System.err.println("Error: " + e.getMessage());
            }
        }
    }

    // Метод для чтения и парсинга файла
    private Map<String, Object> readFileAndParse(String filepath) throws Exception {
        // Чтение содержимого файла в строку
        String content = new String(Files.readAllBytes(Paths.get(filepath)));

        // Создание объекта ObjectMapper для парсинга JSON
        ObjectMapper objectMapper = new ObjectMapper();

        // Преобразование строки в Map
        return objectMapper.readValue(content, Map.class);
    }

    public static void main(String[] args) {
        CommandLine.run(new App(), args);
    }
}
