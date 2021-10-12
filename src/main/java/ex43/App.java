package ex43;

/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Ross Brinkman
 */

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

public class App {
    public static void main( String[] args ) throws IOException {
        String siteName, author, js, css, folderPath = "src/main/java/ex43/website";

        //print questions and read responses
        siteName = Prompt("Site Name: ");
        author = Prompt("Author: ");
        js = Prompt("Do you want a folder for JavaScript? ");
        css = Prompt("Do you want a folder for CSS? ");

        //create directory with new site name as folder name
        CreateNewDirectory(String.format("%s", folderPath));
        CreateNewDirectory(String.format("%s/%s", folderPath, siteName));
        //create new index.html file within new directory
        CreateFileWithInput(
            String.format("%s/%s/index.html", folderPath, siteName),
            String.format("<!DOCTYPE html>\n<html>\n\t<head>\n\t\t<meta name=\"author\" content=\"%s\">" +
            "\n\t\t<title>\n\t\t%s\n\t\t</title>\n\t</head>\n</html>", author, siteName)
        );

        //if user input is "y" create new directory for JavaScript. Same thing for CSS
        if(Objects.equals(js, "y"))
            CreateNewDirectory(String.format("%s/%s/js", folderPath, siteName));

        if(Objects.equals(css, "y"))
            CreateNewDirectory(String.format("%s/%s/css", folderPath, siteName));
    }

    //Prompt will print a new line and return a user input (for ease of clutter)
    public static String Prompt(String toPrint)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print(toPrint);
        return scanner.next().toLowerCase();
    }

    //Create a new directory
    public static boolean CreateNewDirectory(String path)
    {
        File newDirectory = new File(path);
        if(newDirectory.mkdir()) {
            System.out.printf("Created %s\n", path);
            return true;
        }
        else
            return false;
    }

    //create a new file
    public static boolean CreateFileWithInput(String path, String toWrite) throws IOException {
        File html = new File(path);
        boolean success;
        //create a new file
        if(html.createNewFile()) {
            System.out.printf("Created %s\n", path);
            success = true;
        }
        else
            success = false;

        //write html to file
        FileWriter writer = new FileWriter(html);
        writer.write(toWrite);
        writer.close();
        return success;
    }
}
