package ex46;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @Test
    void findAllWordsInFile() throws IOException {
        //FindAllWordsInFile()
        File file = new File("src/main/java/ex46/inputTest.txt");
        FileWriter writer = new FileWriter(file);
        writer.write("COP Object Oriented Oriented Object Oriented");
        writer.close();
        HashMap<String, Integer> hm = App.FindAllWordsInFile(file);
        assertEquals(3, hm.get("Oriented"));
        assertEquals(2, hm.get("Object"));

        //ConvertHashmapToStringListWithValues()
        List<String> list = App.ConvertHashmapToStringListWithValues(hm);
        assertTrue(list.get(0).contains("COP:"));
        assertTrue(list.get(2).contains("**"));

        //SortListByValue
        hm = App.SortListByValue(hm);
        assertEquals("Oriented", hm.keySet().toArray()[0]);
        assertEquals("COP", hm.keySet().toArray()[2]);
    }
}