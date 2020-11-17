package collections;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class CollectionSort {

    static String filepath ="C:\\Users\\PB\\IdeaProjects\\JavaCoreAQA\\src\\main\\java\\resourses\\song.txt";

    static void sortList(List<String> list){
        list.sort(Comparator.naturalOrder());
    }

    public static void main(String[] args) {

        File file = new File(filepath);
        List<String> list = new ArrayList<>();
        try{
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()){
                list.add(scanner.nextLine());
            }
        } catch (IOException e){
            e.getStackTrace();
        }

        sortList(list);
        for (String i:list){
            System.out.println(i);
        }
    }
}
