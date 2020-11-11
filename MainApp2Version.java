package lesson2_1;

import java.util.Arrays;
import java.util.Scanner;

public class MainApp2Version {

    public static void main(String[] args) {
        System.out.println("array- diagonal");
        int [][] arr4=new int[8][8];
        arr4=takeOne(arr4);
        System.out.println();
        System.out.println("min & max of array: ");
        int [] arr3={1,5,3,2,11,4,5,2,4,8,9,1};
        System.out.print(Arrays.toString(arr3));
        minMaxMet(arr3);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число позиций для смещения массива[11]: ");
        int n= scanner.nextInt();
        arrayMoveMember(n);
        System.out.println();
        scanner.close();
    }

    private static void arrayMoveMember(int n) {
        int [] arrMove={1,2,3,4,5,6,7,8,9,10,11};
        System.out.print(Arrays.toString(arrMove));
        if (n == 0) {
            System.out.println(" n=0: массив остается без изменений");
        } else if(n > 0) {
            while (n > arrMove.length) {
                n = n - arrMove.length;
            }
            for (int y = 1; y <= n; y++) {
                int x = arrMove[arrMove.length - 1];
                for (int i = 1; i < arrMove.length; i++) {
                    arrMove[arrMove.length - i] = arrMove[arrMove.length - i - 1];
                }
                arrMove[0] = x;
            }
        } else if (n < 0) {
            int b = n;
            b = Math.abs(b);
            while (b > arrMove.length) {
                b = b - arrMove.length;
            }
            for (int z = 0; z < b; z++) {
                int x = arrMove[0];
                for (int g = 0; g < arrMove.length - 1; g++) {
                    arrMove[g] = arrMove[g + 1];
                }
                arrMove[arrMove.length-1] = x;
            }
        }System.out.print(Arrays.toString(arrMove));
    }

    private static void minMaxMet(int[] arr3) {
        int l;
        int min = arr3[0];
        int max = arr3[0];
        for(l=0;l<arr3.length; l++) {
            if (min > arr3[l]) min = arr3[l];
            else if (max < arr3[l]) max = arr3[l];
        }
        System.out.println();
        System.out.println("min = "+ min);
        System.out.println("max = "+ max);
    }

    private static int[][] takeOne(int[][] arr4) {
        int x = 0;
        int p = 0;
        for (x = 0, p = arr4.length-1; x < arr4.length; x++, p--) {
            for (int u = 0; u < arr4.length; u++) {
                if (x == u||u == p) {
                    arr4[x][u] = 1;
                    System.out.print(arr4[x][u]);
                } else {
                    arr4[x][u] = 0;
                    System.out.print(arr4[x][u]);
                }
            }
            System.out.println();
        }
        return arr4;
    }

//1. Только забыла учесть, что есть и вторая диагональ)
//
//В методе c нахождением с min и max лучше использовать
// только один цикл, немного оптимизируем производительность)
//В последнем задании можно доработать - нужно именно смещать значения, не изменять на 0.
}

