package ex46;

/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Ross Brinkman
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class App {
    public static void main( String[] args ) throws FileNotFoundException {
            File file = new File("src/main/java/ex46/exercise46_input.txt");
            //make a list of each unique word in file
            HashMap<String, Integer> wordList = FindAllWordsInFile(file);
            //sort the words by how many times they appear
            wordList = SortListByValue(wordList);
            //make new list with words + the appropriate amount of asterisks
            List<String> wordsAndCount = ConvertHashmapToStringListWithValues(wordList);
            //print the list
            PrintList(wordsAndCount);
        }

    // loop through lines of file and put each unique word into it's own hashmap with count
    public static HashMap<String, Integer> FindAllWordsInFile(File file) throws FileNotFoundException {
        Scanner sc = new Scanner(file);
        HashMap<String, Integer> words = new HashMap<>();
        while (sc.hasNext())
        {
            String next = sc.next();
            int count = words.getOrDefault(next, 0);
            // if word is already in the hashmap, increment its count
            words.put(next, count + 1);
        }
        return words;
    }

    //convert hashmap into a list of strings, adding asterisks according to its value
    public static List<String> ConvertHashmapToStringListWithValues(HashMap<String, Integer> map)
    {
        List<String> wordsAndValues = new ArrayList<>();
        for(String s : map.keySet())
        {
            String key = s + ":";
            wordsAndValues.add(String.format("%-9s %-9s", key, "*".repeat(Math.max(0, map.get(s)))));
        }
        return wordsAndValues;
    }

    //sort the hashmap according to count value (biggest first)
    public static HashMap<String, Integer> SortListByValue(HashMap<String, Integer> hashMap)
    {
        //convert hashmap to list
        List<Map.Entry<String, Integer> > list =
                new LinkedList<>(hashMap.entrySet());

        //sort list
        list.sort(Map.Entry.comparingByValue());
        Collections.reverse(list);

        //convert list back to hashmap
        HashMap<String, Integer> temp = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }

    //print each element in list
    public static void PrintList(List<String> list)
    {
        for(String s : list)
            System.out.println(s);
    }
}
