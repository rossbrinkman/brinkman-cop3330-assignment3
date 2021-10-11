package ex45;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @Test
    void separateWordsAndScanLinesToList() throws IOException {
        //SeparateWords()
        File outputfile = new File("src/test/java/ex45/exercise45_testOutput.txt");
        if(!outputfile.createNewFile())
            System.out.println("Failed to create file");
        Scanner scanner = new Scanner(outputfile);

        List<String> newList = new ArrayList<>();
        newList.add("Ross"); newList.add("Brinkman"); newList.add("is"); newList.add("great");

        App.SeparateWords(newList, outputfile);
        assertEquals("Ross", scanner.nextLine().trim());
        assertEquals("Brinkman", scanner.nextLine().trim());
        assertEquals("is", scanner.nextLine().trim());
        assertEquals("great", scanner.nextLine().trim());

        //ScanLinesToList()
        assertEquals("is", App.ScanLinesToList(outputfile).get(2).trim());
    }
}