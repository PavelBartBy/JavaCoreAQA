package collections;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PoemSort {

    static String filepath ="C:\\Users\\PB\\IdeaProjects\\JavaCoreAQA\\src\\main\\java\\resourses\\song.txt";

    static List<String> sortList(List<String> list){
        for (int i=list.size()-1; i>=1; i--){
            for (int j=0; j<i; j++){
                if (list.get(j).length()>list.get(j+1).length()){
                    toSwap(list, j,j+1);
                }
            }
        }
        return list;
    }

    public static void toSwap (List<String> list,int a, int b){

        String temp = list.get(a);
        list.set(a,list.get(b));
        list.set(b,temp);
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

        list=sortList(list);
        for (String i:list){
            System.out.println(i);
        }
    }
}
