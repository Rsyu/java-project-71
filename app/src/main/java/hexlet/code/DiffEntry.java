package hexlet.code;

public class DiffEntry {

    private final String key;
    private final Object value1;
    private final Object value2;
    private final String status;

    // Конструктор для создания нового элемента DiffEntry
    public DiffEntry(String key, Object value1, Object value2, String status) {
        this.key = key;
        this.value1 = value1;
        this.value2 = value2;
        this.status = status;
    }

    public String getKey() {
        return key;
    }

    public Object getValue1() {
        return value1;
    }

    public Object getValue2() {
        return value2;
    }

    public String getStatus() {
        return status;
    }
}
