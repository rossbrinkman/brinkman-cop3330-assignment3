package ex43;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @Test
    void createNewDirectory() {
        assertTrue(App.CreateNewDirectory("src/test/java/ex43/test"));
    }

    @Test
    void createFileWithInput() throws IOException {
        assertTrue(App.CreateFileWithInput("src/test/java/ex43/test/this.txt", "THIS"));
    }
}