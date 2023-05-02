package Seminar4;


import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Random;

public class WorkWithLinkedList {
    public static void main(String[] args){
        LinkedList<Integer> originalList = fillList();
        System.out.println("Task 1\n");
        printArray(originalList);
        task1(originalList);
        System.out.println("\nTask 2\n");
        task2();
        System.out.println("\nTask 3, list from task 1 is used\n");
        task3(originalList);
    }

    static LinkedList<Integer> fillList(){
        Random rand = new Random();
        LinkedList<Integer> origin = new LinkedList<>();
        for(int i = 0; i < rand.nextInt(5, 10); i++){
            origin.add(rand.nextInt(0,20));
        }
        return origin;
    }

    static void printArray(LinkedList<Integer> numbers){
        StringBuilder sb = new StringBuilder();
        numbers.forEach((number)-> sb.append(number.toString() +" "
        ));
        System.out.println(sb.toString());
    }
    static void task1(LinkedList<Integer> origin){
        LinkedList<Integer> reversedList = new LinkedList<>();
        ListIterator<Integer> listIterator = origin.listIterator(origin.size());
        while (listIterator.hasPrevious()){
            reversedList.add(listIterator.previous());
        }
        printArray(reversedList);
    }

    static void task2(){
        MyLinkedList list = new MyLinkedList();
        Random rand = new Random();
        for(int i = 0; i < rand.nextInt(5, 10); i++){
            list.enqueue(rand.nextInt(0, 20));
        }

        list.print();
        System.out.println("The first element of our array is: " + list.first());
        System.out.println("The first element of our array is: " + list.dequeue());
        list.print();
    }
    static void task3(LinkedList<Integer> source){
        int sum = 0;
        ListIterator<Integer> listIterator = source.listIterator();
        while (listIterator.hasNext()){
            sum += listIterator.next();
        }
        System.out.println("Sum of elements equals: " + sum);
    }


}
