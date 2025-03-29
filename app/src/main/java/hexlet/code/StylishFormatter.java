package hexlet.code;

import java.util.List;

public class StylishFormatter {

    public static void printStylish(List<DiffEntry> diff) {
        System.out.println("{");
        for (DiffEntry entry : diff) {
            String status = entry.getStatus();
            String key = entry.getKey();
            Object value1 = entry.getValue1();
            Object value2 = entry.getValue2();

            switch (status) {
                case "added":
                    System.out.println("  + " + key + ": " + value2);
                    break;
                case "removed":
                    System.out.println("  - " + key + ": " + value1);
                    break;
                case "changed":
                    System.out.println("  - " + key + ": " + value1);
                    System.out.println("  + " + key + ": " + value2);
                    break;
                case "unchanged":
                    System.out.println("    " + key + ": " + value1);
                    break;
                default:
                    throw new IllegalStateException("Unexpected status: " + status);
            }
        }
        System.out.println("}");
    }
}
