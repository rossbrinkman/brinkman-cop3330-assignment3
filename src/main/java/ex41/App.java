package ex41;

/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Ross Brinkman
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class App {
    //Start here
    public static void main( String[] args ) throws IOException {
        //Read file input
        List<String> list = ReadInput();
        //Sort input
        Collections.sort(list);
        //Output to file
        OutputToFile(list);
    }

    //Read input from input file
    public static List<String> ReadInput() throws FileNotFoundException
    {
            File file = new File("src/main/java/ex41/exercise41_input.txt");
            Scanner sc = new Scanner(file);
            List<String> names = new ArrayList<>();

            //loop through each line adding it to a list
            while (sc.hasNextLine())
                names.add(sc.nextLine());
            sc.close();
            //return the list
            return names;
    }

    //output to file function
    public static boolean OutputToFile(List<String> sortedList) throws IOException {
        FileWriter writer = new FileWriter("src/main/java/ex41/exercise41_output.txt");
        //Print total number of names
        writer.write(String.format("Total of %d names\n-----------------", sortedList.size()) + System.lineSeparator());
        //loop through list and write each line to new file
        for(String str: sortedList)
            writer.write(str + System.lineSeparator());
        writer.close();
        return true;
    }
}
