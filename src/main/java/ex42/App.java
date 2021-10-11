package ex42;

/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Ross Brinkman
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class App {
    public static void main( String[] args ) throws IOException {
        //Call funtion to populate hashmap list
        List<HashMap<String, String>> employeeData = PopulateMapList();
        //function to output data to new file
        Output(employeeData);
    }

    //output to file function
    public static void Output(List<HashMap<String, String>> employeeData) {
        //print initial statement
        System.out.printf("%-9s %-9s %-9s\n--------------------------\n", "Last", "First", "Salary");
        //loop through hashmap, printing last name, first name, and salary for each element
        for(HashMap<String, String> hashMap: employeeData) {
            System.out.printf("%-9s %-9s %-9s" + System.lineSeparator(), hashMap.get("Last Name"),
                    hashMap.get("First Name"), hashMap.get("Salary"));
        }
    }

    //populate the list of hashmaps
    public static List<HashMap<String, String>> PopulateMapList() throws FileNotFoundException {
        File file = new File("src/main/java/ex42/exercise42_input.txt");
        Scanner sc = new Scanner(file);
        List<HashMap<String, String>> employees = new ArrayList<>();

        //loop through input file and add first, last name and salary as maps
        int empIndex = 0;
        while (sc.hasNextLine()) {
            employees.add(new HashMap<>());
            String employee = sc.nextLine();
            List<String> result = Arrays.asList(employee.split("\\s*,\\s*"));
            employees.get(empIndex).put("Last Name", result.get(0));
            employees.get(empIndex).put("First Name", result.get(1));
            employees.get(empIndex).put("Salary", result.get(2));
            empIndex++;
        }
        sc.close();
        return employees;
    }
}
