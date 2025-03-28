package hexlet.code;

import org.junit.jupiter.api.Test;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DifferTest {

    @Test
    void testGenerateYamlFiles() throws IOException {
        // Пути к YAML файлам
        String file1 = "src/test/resources/file1.yml";
        String file2 = "src/test/resources/file2.yml";

        // Ожидаемый результат сравнения файлов
        String expectedResult = """
                {
                  - follow: false
                    host: hexlet.io
                  - proxy: 123.234.53.22
                  - timeout: 50
                  + timeout: 20
                  + verbose: true
                }""" ;

        // Генерация результата сравнения файлов
        String actualResult = Differ.generate(file1, file2);

        // Сравнение ожидаемого и реального результатов
        assertEquals(expectedResult.trim(), actualResult.trim());
    }

    @Test
    void testGenerateJsonFiles() throws IOException {
        // Пути к JSON файлам
        String file1 = "src/test/resources/file1.json";
        String file2 = "src/test/resources/file2.json";

        // Ожидаемый результат сравнения файлов
        String expectedResult = """
                {
                  - follow: false
                    host: hexlet.io
                  - proxy: 123.234.53.22
                  - timeout: 50
                  + timeout: 20
                  + verbose: true
                }""" ;

        // Генерация результата сравнения файлов
        String actualResult = Differ.generate(file1, file2);

        // Сравнение ожидаемого и реального результатов
        assertEquals(expectedResult.trim(), actualResult.trim());
    }
}
