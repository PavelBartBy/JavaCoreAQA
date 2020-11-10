import java.util.Arrays;

public class OptionalTask1 {
    public static void main(String[] args) {
//        Задание. Ввести n чисел с консоли.
//        1.     Найти самое короткое и самое длинное число. Вывести найденные числа и их длину.
//        2.     Вывести числа в порядке возрастания (убывания) значений их длины.
//        3.     Вывести на консоль те числа, длина которых меньше (больше) средней длины по всем числам, а также длину.
//        4.     Найти число, в котором количество различных цифр минимально. Если таких чисел несколько, найти первое из них.
//        5.     Найти количество чисел, содержащих только четные цифры, а среди оставшихся — количество чисел с равным числом четных и нечетных цифр.
//        6.     Найти число, цифры в котором идут в строгом порядке возрастания. Если таких чисел несколько, найти первое из них.
//        7.     Найти число, состоящее только из различных цифр. Если таких чисел несколько, найти первое из них.
//
//      p1.
        String lowNum = null;
        int lowNumLength= 126;
        String highNum = null;
        int highNumLength= 0;
        for(String i:args){
            if (i.length()<lowNumLength){
                lowNum=i;
                lowNumLength=i.length();
            }
            if (i.length()>highNumLength){
                highNum=i;
                highNumLength=i.length();
            }
        }
        System.out.println(lowNum+": "+lowNumLength + "\n "+ highNum+": "+highNumLength);

//      p2.
        String temp;
        for(int i=0; i<args.length-1;i++){
            for (int j=i+1; j< args.length;j++){
                if (args[i].length()>args[j].length()){
                    temp=args[j];
                    args[j]=args[i];
                    args[i]=temp;
                }
            }
        }
        System.out.println("Wih length up: "+ Arrays.toString(args));
        System.out.println("With length down: ");
        for (int i=args.length-1; i>=0; i--){
            System.out.print(" "+args[i]+" ");
        }
        System.out.println();

//      p3.
        int average = 0;
        for(String i:args){
            average+=i.length();
        }
        average=average/ args.length;
        System.out.println("Numbers with shorter length than average: ");
        for(String i:args){
            if(i.length()<average){
                System.out.print(i+" ");
            }
        }
        System.out.println();
        System.out.println("Numbers with longer length than average: ");
        for(String i:args){
            if(i.length()>average){
                System.out.print(i+" ");
            }
        }
        System.out.println();
//
//        p4.
        char[] cArray;
        double minChar = 0;
        String element= null;
        for(String i:args){
            cArray=i.toCharArray();
            int tempChar=0;
            double coeff = 0;
            for (int j=0;j<cArray.length-1;j++){
                for (char c : cArray) {
                    if (cArray[j] == c) {
                        tempChar++;
                    }
                }
                coeff+=tempChar;
            }
            coeff=coeff/cArray.length;
            if (coeff>minChar){
                minChar=coeff;
                element=i;
            }
        }
        System.out.println(" Number with min unique parts: "+element);
//
//        p5.
        char[] secondCharArray;
        int quatityOfEven= 0;
        int quantityOfBalance = 0;
        int balance;
        boolean relay = false;
        for(String i:args) {
            secondCharArray = i.toCharArray();
            balance=0;
            for (char j:secondCharArray){
                if((((int)j)%2)==0){
                    relay=true;
                } else{
                    relay=false;
                    break;
                }
            }
            if(relay){
                quatityOfEven++;
            }
            for (char j:secondCharArray){
                if((((int)j)%2)==0){
                    balance++;
                } else{
                    balance--;
                }
            }
            if(balance==0){
                quantityOfBalance++;
            }
        }
        System.out.println("Quantity of numbers with only even parts is: "+quatityOfEven);
        System.out.println("Quantity of numbers with balance between even and odd parts is: "+quantityOfBalance);
//
//    p6.

        relay=false;
        for(String i:args) {
            secondCharArray = i.toCharArray();
            for (int j=0;j<secondCharArray.length-1;j++) {
                if((int)secondCharArray[j]<(int)secondCharArray[j+1]){
                    relay=true;
                } else{
                    relay=false;
                    break;
                }
            }
            if(relay){
                System.out.println("First number with in ascending order parts is: "+ i);
                break;
            }
        }
//
//        p7.
        relay=false;
        for(String i:args) {
            secondCharArray = i.toCharArray();
            for (int j=0;j<secondCharArray.length-1;j++) {
                for (int k=j+1;k< secondCharArray.length;k++){
                    if((int)secondCharArray[j]!=(int)secondCharArray[k]){
                        relay=true;
                    } else {
                        relay=false;
                        break;
                    }
                }
            }
            if(relay){
                System.out.println("First number with unique parts: "+i);
                break;
            }

        }
    }
}
