package ex41;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @Test
    void main() throws IOException {
        List<String> list = new ArrayList<>();
        list.add("Hello"); list.add("I ");list.add("am");list.add("Ross");
        assertTrue(App.OutputToFile(list));
    }
}