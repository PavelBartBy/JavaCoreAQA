package collections;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class CheckStringBrackets {

    static boolean checkBrackets(Deque<Character> stack){

        String rightBrackets = ")}]";
        char[] rightBracketsArray = rightBrackets.toCharArray();
        String leftBrackets = "({[";
        char[] leftBracketsArray = leftBrackets.toCharArray();
        int count=0;
        while (stack.peek()!=null){
            char elementOfStack = stack.pop();
            for (char i:rightBracketsArray){
                if(elementOfStack==i){
                    count+=rightBrackets.indexOf(i)+1;
                    }
                }
            for(char i:leftBracketsArray){
                if(elementOfStack==i){
                    count-=leftBrackets.indexOf(i);
                    count--;
                }
            }
        }
        return count == 0;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please input string with brackets");
        String inputLine = reader.readLine();
        char[] ourCharArray = inputLine.toCharArray();
        Deque<Character> stack = new ArrayDeque<>();
        for (int i=0; i<ourCharArray.length; i++){
            stack.addFirst(ourCharArray[i]);
        }

        if(checkBrackets(stack)){
            System.out.println("String correct");
        } else System.out.println("String not correct. Missing some brackets");

    }
}
