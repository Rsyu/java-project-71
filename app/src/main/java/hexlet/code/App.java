package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;
import picocli.CommandLine.Command;
import java.util.concurrent.Callable;

@Command(
        name = "gendiff",
        description = "Compares two configuration files and shows a difference.",
        mixinStandardHelpOptions = true, // Поддержка --help и --version
        version = "gendiff 1.0"
)
public class App implements Callable<Integer> {

    @Parameters(index = "0", description = "Path to first file", defaultValue = "")
    private String filepath1;

    @Parameters(index = "1", description = "Path to second file", defaultValue = "")
    private String filepath2;

    @Option(names = {"-f", "--format"}, description = "Output format [default: stylish]", defaultValue = "stylish")
    private String format;

    @Override
    public Integer call() {
        if (filepath1.isEmpty() || filepath2.isEmpty()) {
            System.err.println("Error: Both file paths must be provided.");
            return 1;
        }

        try {
            String diff = Differ.generate(filepath1, filepath2);
            System.out.println(diff);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }
}
