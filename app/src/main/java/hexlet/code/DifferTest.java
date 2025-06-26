package hexlet.code;

import org.junit.jupiter.api.Test;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DifferTest {

    private static final String FIXTURES_PATH = "src/test/resources/";

    @Test
    void testGenerateDiffFlatJson() throws Exception {
        String file1 = getFixturePath("file1.json");
        String file2 = getFixturePath("file2.json");
        String expected = """
            {
              - follow: false
                host: hexlet.io
              - proxy: 123.234.53.22
              - timeout: 50
              + timeout: 20
              + verbose: true
            }""";

        String actual = Differ.generate(file1, file2);
        assertEquals(expected.trim(), actual.trim());
    }

    private String getFixturePath(String filename) {
        return Path.of(FIXTURES_PATH, filename).toAbsolutePath().normalize().toString();
    }
}
