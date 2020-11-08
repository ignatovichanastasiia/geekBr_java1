package Geekbrains.java1.lesson2;

import java.util.Arrays;
import java.util.Scanner;

public class MainApp2 {
    public static void main(String[] args) {
        int [] arr1={1,1,0,0,1,0,1,1,0,0};
        System.out.println("change 1 to 0, 0 to 1");
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(changeNum(arr1)));
        int [] arr2=new int[8];
        System.out.println("array step 3");
        System.out.println(Arrays.toString(addArr(arr2)));
        int [] arr3={1,5,3,2,11,4,5,2,4,8,9,1};
        System.out.println("array: *2 if num<6");
        System.out.println(Arrays.toString(arr3));
        System.out.println(Arrays.toString(multiArr(arr3)));
        System.out.println("НЕ ПОНЯЛА, ПОЧЕМУ ИЗ 3-х ВЕРСИЙ, КВАДРАТ - ТОЛЬКО ОДНА:");
        System.out.println("array- diagonal");
        int [][] arr4=new int[8][8];
        arr4=takeOne(arr4);
        System.out.println("array- diagonal2");
        int [][] arrDbl=new int[8][8];
        arrDbl=takeOne2(arrDbl);
        printArr(arrDbl);
        System.out.println("array- diagonal3");
        int [][] arrTh = new int [8][8];
        arrTh=shortVerTaOne(arrTh);
        printArr(arrTh);
        System.out.println();
        System.out.println("min & max of array: ");
        System.out.print(Arrays.toString(arr3));
        minMaxMet(arr3);
        int[] arrAdd = new int[8];
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите последовательно (через ввод) 8 чисел для составления массива(balance): ");
        arrAdd[0] = scanner.nextInt();
        arrAdd[1] = scanner.nextInt();
        arrAdd[2] = scanner.nextInt();
        arrAdd[3] = scanner.nextInt();
        arrAdd[4] = scanner.nextInt();
        arrAdd[5] = scanner.nextInt();
        arrAdd[6] = scanner.nextInt();
        arrAdd[7] = scanner.nextInt();
        boolean result=balance(arrAdd);
        System.out.println(result);
        System.out.println("Введите число позиций для смещения массива[11]: ");
        int n= scanner.nextInt();
        arrayMoveMember(n);
        System.out.println();
        scanner.close();
    }

    private static void arrayMoveMember(int n) {
        int [] arrMove={1,2,3,4,5,6,7,8,9,10,11};
        System.out.print(Arrays.toString(arrMove));
        if (n==0) {
            System.out.println(" n=0: массив остается без изменений");
        }else if(n>0) {
            for (int i = 1; i <= arrMove.length; i++) {
                if (i <= arrMove.length - n) {
                    arrMove[arrMove.length - i] = arrMove[arrMove.length - n - i];
                } else {
                    arrMove[arrMove.length - i] = 0;
                }
            }
        }else if (n<0){
            for (int g=0; g<= arrMove.length-1; g++){
                if (g<= arrMove.length+n-1){
                    arrMove[g] = arrMove[g-n];
                } else {
                    arrMove[g]=0;
                }
            }
        }System.out.print(Arrays.toString(arrMove));
    }

    private static boolean balance(int[] arrAdd) {
        boolean result = false;
        int score = 0;
        int g = arrAdd.length - 1;
        while (score <= g) {
            int num2 = 0;
            int num1 = 0;
            int l = g;
            int i = 0;
            if (score == g) {
                break;
            } else {
                for (i = 0; i <= score; i++) {
                    num1 = num1 + arrAdd[i];
                }
                for (l = g; l > score; l--) {
                    num2 = num2 + arrAdd[l];
                }
                if (num1 == num2) {
                    result=true;
                    break;
                } else {
                    score++;
                }
            }
        }return result;
    }

    private static void minMaxMet(int[] arr3) {
        int l;
        int min = arr3[0];
        int max = arr3[0];
        for(l=0;l<arr3.length; l++) {
            if (min > arr3[l]) min = arr3[l];
        }
        System.out.println();
        System.out.println("min = "+ min);
        for(l=0;l<arr3.length; l++) {
            if (max < arr3[l]) max = arr3[l];
        }
        System.out.println("max = "+ max);
    }

    private static int[][] takeOne(int[][] arr4) {
        for (int x = 0; x < arr4.length; x++) {
            for (int u = 0; u < arr4.length; u++) {
                if (x == u) {
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

    private static int[][] takeOne2(int[][] arrDbl) {
        int x=0,u=0;
        for(x=0;x< arrDbl.length;x++){
            for(u=0;u< arrDbl.length;u++){
                if(x==u){
                    arrDbl[x][u]=1;
                }else{
                    arrDbl[x][u]=0;
                }
            }
        }return arrDbl;
    }

    private static int[][] shortVerTaOne(int[][] arrTh) {
        for (int y=0;y<arrTh.length;y++) {
            arrTh[y][y]=1;
        }return arrTh;
    }

    private static void printArr(int[][] arrDbl) {
        int b,c;
        for(b=0;b<arrDbl.length;b++){
            for(c=0;c<=b;c++){
                System.out.print(arrDbl[b][c]);
            }System.out.println();
        }
    }

    private static int[] multiArr(int[] arr3) {
        for(int z=0;z<arr3.length;z++) {
            if(arr3[z]<6) arr3[z]=arr3[z]*2;
        }return arr3;
    }

    private static int[] addArr(int[] arr2) {
        int x,j;
        for (x = 0, j = 0; x<arr2.length; x++, j += 3){
            arr2[x] = j;
        }return arr2;
    }

    private static int[] changeNum(int [] arr){
        for(int i=0;i<arr.length;i++) {
            if (arr[i] == 0) {
                arr[i] = 1;
            } else {
                arr[i] = 0;
            }
        }return arr;
    }



//1. Задать целочисленный массив, состоящий из элементов 0 и 1. Например:
// [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;
//2. Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями
// 0 3 6 9 12 15 18 21;
//3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом,
// и числа меньшие 6 умножить на 2;
//4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
// и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
//5. ** Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);
//6. ** Написать метод, в который передается не пустой одномерный целочисленный массив,
// метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой части массива равны.
// Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true, checkBalance([1, 1, 1, || 2, 1]) → true,
// граница показана символами ||, эти символы в массив не входят.
// 7. **** Написать метод, которому на вход подается одномерный массив и число n (может быть
// положительным, или отрицательным), при этом метод должен сместить все элементымассива на n позиций.
// Для усложнения задачи нельзя пользоваться вспомогательными массивами.
}
