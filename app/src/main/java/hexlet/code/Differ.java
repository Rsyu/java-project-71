package hexlet.code;

import java.util.*;

public class Differ {

    public static List<DiffEntry> generateDiff(Map<String, Object> file1Data, Map<String, Object> file2Data) {
        List<DiffEntry> diff = new ArrayList<>();
        Set<String> allKeys = new TreeSet<>(file1Data.keySet());
        allKeys.addAll(file2Data.keySet()); // объединяем ключи из обоих файлов

        for (String key : allKeys) {
            Object value1 = file1Data.get(key);
            Object value2 = file2Data.get(key);

            // Если значения равны или оба значения равны null
            if (value1 == null && value2 == null) {
                diff.add(new DiffEntry(key, null, null, "unchanged"));
            } else if (value1 == null) {
                diff.add(new DiffEntry(key, null, value2, "added"));
            } else if (value2 == null) {
                diff.add(new DiffEntry(key, value1, null, "removed"));
            } else if (!value1.equals(value2)) {
                diff.add(new DiffEntry(key, value1, value2, "changed"));
            } else {
                diff.add(new DiffEntry(key, value1, value2, "unchanged"));
            }
        }
        return diff;
    }
}
