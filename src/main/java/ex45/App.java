package ex45;

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
    public static void main( String[] args ) throws IOException {
        File file = new File("src/main/java/ex45/exercise45_input.txt");

        //prompt user for output file name
        String output = Prompt("Please input the name of an output file: ");

        //create the new output file
        File outputFile = new File("src/main/java/ex45/" + output);
        if(!outputFile.createNewFile())
            System.out.print("Unable to create new file");

        //scan the input file into a list of lines
        List<String> lines = ScanLinesToList(file);
        //separate all lines into word list
        SeparateWords(lines, outputFile);
    }

    //function for printing statement and prompting user input
    public static String Prompt(String toPrint)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print(toPrint);
        return scanner.next().toLowerCase();
    }

    // output every word to new file
    // if word is "utilize" replace it with "use"
    public static void OutputToFile(List<String> words, FileWriter fileWriter) throws IOException {
        for(String s : words) {
            String currentWord = s;
            if(currentWord.toLowerCase().contains("utilize"))
                currentWord = currentWord.replace("utilize", "use");
            fileWriter.write(currentWord + " ");
        }
        fileWriter.write("\n");
    }

    //separate each line in list into individual words
    public static void SeparateWords(List<String> lines, File outputFile) throws IOException {
        FileWriter writer = new FileWriter(outputFile);
        List<String> words;
        for(String s : lines) {
            words = Arrays.asList(s.split("\\s* \\s*"));
            OutputToFile(words, writer);
        }
        writer.close();
    }

    //scan each line in the file into list of strings
    public static List<String> ScanLinesToList(File file) throws FileNotFoundException {
        Scanner fileScanner = new Scanner(file);
        List<String> lines = new ArrayList<>();

        while (fileScanner.hasNextLine())
            lines.add(fileScanner.nextLine());

        return lines;
    }
}
