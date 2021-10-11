package ex42;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @Test
    void populateMapList() throws FileNotFoundException {
        assertEquals("Swift", App.PopulateMapList().get(4).get("Last Name"));
    }
}