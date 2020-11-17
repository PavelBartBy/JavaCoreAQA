package collections;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ImportExportTask {

    public static String filepath ="C:\\Users\\PB\\IdeaProjects\\JavaCoreAQA\\src\\main\\java\\resourses\\song.txt";

    public static void main(String[] args) {
        File file = new File(filepath);
        List<String> list = new ArrayList<>();
        List<String> newList = new ArrayList<>();
        try{
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()){
            list.add(scanner.nextLine());
            }
            String newFilePath = "C:\\Users\\PB\\IdeaProjects\\JavaCoreAQA\\src\\main\\java\\resourses\\newfilesong.txt";
            FileWriter writer = new FileWriter(newFilePath);
            for (int i=list.size()-1; i>=0; i--){
                newList.add(list.get(i));
            }
            System.out.println(list.toString());
            System.out.println(newList.toString());

            writer.write(newList.toString());
            writer.flush();
            writer.close();
        } catch (IOException e){
            e.getStackTrace();
        }
    }
}
