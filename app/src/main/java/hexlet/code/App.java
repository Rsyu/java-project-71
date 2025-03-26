package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Option;
import picocli.CommandLine.Command;

@Command(name = "gendiff", description = "Compares two configuration files and shows a difference.")
public class App implements Runnable {

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
            System.out.println("Hello World!");
        }
    }

    public static void main(String[] args) {
        CommandLine.run(new App(), args);
    }
}
