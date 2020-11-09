import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.time.Month;
import java.util.Arrays;
import java.util.Random;

public class MainTask {

    public static String reverseString(String str){
        return new StringBuilder(str).reverse().toString();
    }
    public static void main(String[] args) throws IOException {

        String inputLine;
        Reader input = new InputStreamReader(System.in);
        BufferedReader bufferredReader = new BufferedReader(input);

//        1.     Приветствовать любого пользователя при вводе его имени через командную строку.
        System.out.println("Plese, input your name: ");
        inputLine=bufferredReader.readLine();
        System.out.println("Hello, "+inputLine);

//        2.     Отобразить в окне консоли аргументы командной строки в обратном порядке.
        if (args.length==0) {
            System.out.println("Or like this: Hello, " + reverseString(inputLine) + "! Ha-ha");
        } else {
                for (int i=args.length-1; i==0; i--){
                    System.out.print(args[i]+ " ");
                }
            }

//        3.     Вывести заданное количество случайных чисел с переходом и без перехода на новую строку
        System.out.println("Please input positive number:");
        inputLine= bufferredReader.readLine();
        final Random random = new Random();
        for (int i=1; i<=Integer.parseInt(inputLine);i++){
            System.out.println(random.nextInt());
        }
        System.out.println("And this:");
        for (int i=1; i<=Integer.parseInt(inputLine);i++){
            System.out.print(random.nextInt()+" ");
        }
        System.out.println(" ");
//        4.     Ввести целые числа как аргументы командной строки, подсчитать их сумму (произведение) и вывести результат на консоль.
        int sum = 0;
        long mult = 1;
        if (args.length==0){
            System.out.println("Please input numbers through a space:");
            inputLine= bufferredReader.readLine();
            int[] numArray = Arrays.stream(inputLine.split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int i:numArray){
                sum+=i;
                mult=mult*i;
            }
        }
        else{
            for (String i:args){
                sum+=Integer.parseInt(i);
                mult=mult*Integer.parseInt(i);
            }
        }
        System.out.println("Sum: "+sum+" Multipl: "+mult);
//        Ввести число от 1 до 12. Вывести на консоль название месяца, соответствующего данному числу. Осуществить проверку корректности ввода чисел.
        System.out.println("Please input number from 1 to 12:");
        inputLine = bufferredReader.readLine();
        int number = Integer.parseInt(inputLine);
        while (!(number>=1 && number<=12)){
            System.out.println("Not correct number. Please input number from 1 to 12:");
            inputLine = bufferredReader.readLine();
            number = Integer.parseInt(inputLine);
        }
        System.out.println(Month.of(number));
    }
}
