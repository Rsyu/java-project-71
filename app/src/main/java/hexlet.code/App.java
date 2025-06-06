package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

@Command(name = "app", mixinStandardHelpOptions = true)
public class App implements Runnable {

    @Parameters(index = "0", description = "First JSON file path")
    private String filepath1;

    @Parameters(index = "1", description = "Second JSON file path")
    private String filepath2;

    @Override
    public void run() {
        try {
            String diff = Differ.generate(filepath1, filepath2);
            System.out.println(diff);
        } catch (Exception e) {
            System.err.println("Error comparing files: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }
}
