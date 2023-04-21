package Seminar1;

import java.util.Scanner;

public class TriangleNumber {
    public static void main(String[] args) {
        task1();
        task2();
        task3();
        task4();
    }

    public static void task1(){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter which triangle number you would like to know: ");
        int n = in.nextInt();
        System.out.println("Your number is " + ((n+1)*n)/2);
    }

    public static void task2(){
        Scanner in = new Scanner(System.in);
        System.out.println("Factorial of which number you would like to know: ");
        int num = in.nextInt();
        int factorial = 1;
        for(int i = 1; i <= num; i++){
            factorial *= i;
        }
        System.out.println(num + "! = " + factorial);
    }

    public static void task3(){
        for (int j = 2; j <= 1000; j++) {
            boolean isSimple = false;

            for (int i = 2; i * i <= j; i++) {
                isSimple = (j % i == 0);
                if (isSimple) {
                    break;
                }
            }
            if (!isSimple) {
                System.out.print(j + " ");
            }
        }
    }

    public static void task4(){

        Scanner in = new Scanner(System.in);
        boolean cont = true;
        while (cont) {
            System.out.println("\nWhich operation you would like to do: \n1) sum (+), \n2) subtraction (-), " +
                    "\n3) division (/), \n4) multiply (*).\nTo exit enter 0");
            int operation = in.nextInt();
            int firstNum,secondNum;
            switch (operation) {
                case 1:
                    System.out.println("Enter the first number: ");
                    firstNum = in.nextInt();
                    System.out.println("Enter the second number: ");
                    secondNum = in.nextInt();
                    System.out.println(firstNum + " + " + secondNum + " = " + (firstNum + secondNum));
                    break;
                case 2:
                    System.out.println("Enter the first number: ");
                    firstNum = in.nextInt();
                    System.out.println("Enter the second number: ");
                    secondNum = in.nextInt();
                    System.out.println(firstNum + " - " + secondNum + " = " + (firstNum - secondNum));
                    break;
                case 3:
                    System.out.println("Enter the first number: ");
                    firstNum = in.nextInt();
                    System.out.println("Enter the second number: ");
                    secondNum = in.nextInt();
                    System.out.println(firstNum + " / " + secondNum + " = " + (firstNum / secondNum));
                    break;
                case 4:
                    System.out.println("Enter the first number: ");
                    firstNum = in.nextInt();
                    System.out.println("Enter the second number: ");
                    secondNum = in.nextInt();
                    System.out.println(firstNum + " * " + secondNum + " = " + (firstNum * secondNum));
                    break;
                case 0:
                    cont = false;
                    break;
                default:
                    break;
            }
        }
    }

}