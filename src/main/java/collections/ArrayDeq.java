package collections;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class ArrayDeq {



    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please input some big number");
        String inputLine = reader.readLine();
        char[] ourCharArray = inputLine.toCharArray();
        Deque<Character> stack = new ArrayDeque<>();
        for (int i=0; i<ourCharArray.length; i++){
            stack.addFirst(ourCharArray[i]);
        }
        for (char j:stack){
            System.out.print(j);
        }
    }
}
