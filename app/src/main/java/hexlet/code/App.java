package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.List;

@Command(name = "app", mixinStandardHelpOptions = true, version = "1.0",
        description = "Compare two files and generate a diff.")
public class App implements Runnable {

    @Option(names = {"-f", "--format"}, description = "Output format")
    private String format = "stylish"; // формат по умолчанию

    @Option(names = {"-i", "--input1"}, required = true, description = "First input file")
    private String file1;

    @Option(names = {"-j", "--input2"}, required = true, description = "Second input file")
    private String file2;

    @Override
    public void run() {
        try {
            // Чтение данных из файлов
            Map<String, Object> file1Data = Parser.parse(file1);
            Map<String, Object> file2Data = Parser.parse(file2);

            // Генерация различий
            List<DiffEntry> diff = Differ.generateDiff(file1Data, file2Data);

            // Вывод дифа в стиле "stylish"
            if (format.equals("stylish")) {
                StylishFormatter.printStylish(diff);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }
}
