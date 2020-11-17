package fundamentals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Random;

public class OptionalTask2 {
    public static void main(String[] args) throws IOException, InterruptedException {

        //        Задание. Ввести с консоли n - размерность матрицы a [n] [n]. Задать значения элементов матрицы в интервале
        //        значений от -M до M с помощью генератора случайных чисел (класс Random).
//
//        1.     Упорядочить строки (столбцы) матрицы в порядке возрастания значений элементов k-го столбца (строки).
//
//        2.     Найти и вывести наибольшее число возрастающих (убывающих) элементов матрицы, идущих подряд.
//
//        3.     Найти сумму элементов матрицы, расположенных между первым и вторым положительными элементами каждой строки
//
//        4.     Найти максимальный элемент в матрице и удалить из матрицы все строки и столбцы, его содержащие
//
        String inputLine;
        Reader input = new InputStreamReader(System.in);
        BufferedReader bufferredReader = new BufferedReader(input);

        int n = Integer.parseInt(args[0]);
        int m = Integer.parseInt(args[1]);
        int min = -m;
        final Random random = new Random();
        long[][] a = new long[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = random.nextInt(m - min) + min;
            }
        }
        for (long[] i : a) {
            for (long j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }


//        p1.
        System.out.println("Please input k-string");
        inputLine = bufferredReader.readLine();
        int k = Integer.parseInt(inputLine);
        long[][] b = a.clone();
        long[] temp;
        if (k <= n) {
            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (b[i][k] > b[j][k]) {
                        temp = b[j];
                        b[j] = b[i];
                        b[i] = temp;
                    }
                }
            }
        }
//
//        p2.
        int numSeries = 0;
        int count = 1;
        long prevElement = a[0][0];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i][j] > prevElement) {
                    count++;
                } else {
                    if (count > numSeries) {
                        numSeries = count;
                    }
                    count = 1;
                }
                prevElement = a[i][j];
            }
        }
        System.out.println("Max count in ascending order: " + numSeries);
//
//        p3.
        long sumElements=0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n-1; j++) {
                if(a[i][j]>0){
                    for (int z=j+1;z<n;z++){
                        if(a[i][z]<0){
                            sumElements+=a[i][z];
                        } else{
                            break;
                        }
                    }
                }
            }
        }
        System.out.println("Sum of elments between two positive numbers: "+sumElements);
//
//        p4.
        long maxElemnt =-m;
        int delI=0;
        int delJ=0;
        ArrayList<Long> tempA = new ArrayList<>();
        for (int i=0; i<n;i++){
            for (int j=0;j<n;j++) {
                if(a[i][j]>maxElemnt){
                    maxElemnt=a[i][j];
                    delI=i;
                    delJ=j;
                }
            }
        }
        System.out.println("Max element: "+maxElemnt);
        for (int i=0; i<n;i++){
            for (int j=0;j<n;j++) {
                if((i==delI) | (j==delJ)){
                    a[i][j]=0;
                }
            }
        }
        for (int i=0; i<n;i++){
            for (int j=0;j<n;j++) {
                if(a[i][j]!=0){
                    tempA.add(a[i][j]);
                }
            }
        }
        long[][] matrixNew = new long[n-1][n-1];
        int index=0;
        for (int i=0; i<n-1;i++) {
            for (int j = 0; j < n-1; j++) {
                matrixNew[i][j]= tempA.get(index);
                index++;
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }

    }
}
