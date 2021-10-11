package ex44;

/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Ross Brinkman
 */

import com.google.gson.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicReference;

public class App {
    public static void main( String[] args ) throws IOException {
        //parse the json array and find products in a loop
        JsonArray jsonArray = ParseJsonToProductArray();
        FindProductDataLoop(jsonArray);
    }

    public static double FindProductDataLoop(JsonArray jsonArray)
    {
        while(true)
        {
            //take user input for product name
            String input = Prompt("What is the product name? ");

            boolean found;
            AtomicReference<JsonObject> obj = new AtomicReference<>();
            //call search function to see if found or not
            found = SearchForNameInJsonArray(jsonArray, input, obj);

            //if found, print appropriate statements
            if(found) {
                PrintFoundOrNotFound(obj, true);
                return 1;
            }
            else
                PrintFoundOrNotFound(obj, false);
        }
    }

    //search for name in the json array
    public static boolean SearchForNameInJsonArray(JsonArray jsonArray, String input, AtomicReference<JsonObject> obj)
    {
        boolean found;
        //loop through array and compare user input to each name
        for (int i = 0; i < jsonArray.size(); i++) {

            obj.set(jsonArray.get(i).getAsJsonObject());
            String value = obj.get().get("name").getAsString().toLowerCase();

            found = Objects.equals(input, value);

            //if the name is found, return true, otherwise return false
            if(found)
                return true;
        }
        return false;
    }

    //function to print out appropriate data
    public static void PrintFoundOrNotFound(AtomicReference<JsonObject> obj, boolean found)
    {
        if(found)
        {
            System.out.println("Name: " + obj.get().get("name").getAsString());
            System.out.println("Price: " + obj.get().get("price").getAsString());
            System.out.println("Quantity: " + obj.get().get("quantity").getAsString());
        }
        else
        {
            System.out.println( "Sorry, that product was not found in our inventory." );
        }
    }

    //easy prompt function to write and scan input easily
    public static String Prompt(String toPrint)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print(toPrint);
        return scanner.next().toLowerCase();
    }

    //parse the json array using gson library functions
    public static JsonArray ParseJsonToProductArray() throws IOException {
        Path jsonPath = Path.of("src/main/java/ex44/exercise44_input.json");
        String json = Files.readString(jsonPath);

        JsonElement jsonElement = JsonParser.parseString(json);
        JsonObject jsonObject = jsonElement.getAsJsonObject();

        return jsonObject.getAsJsonArray("products");
    }
}
