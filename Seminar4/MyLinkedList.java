package Seminar4;

public class MyLinkedList {
    private Integer[] array = new Integer[10];
    private int maxLength = 150;
    private int minLength = 10;
    private int lastElement = 0;
    private int firstElement = 0;

    int size(){
        return lastElement - firstElement;
    }

    boolean empty(){
        return lastElement - firstElement == 0;
    }

    public void enqueue(int element){
        if (lastElement - firstElement == array.length){
            Integer[] array2 = new Integer[array.length + 10];
            System.arraycopy(array, firstElement, array2,0, array.length);
            array = array2;
        }
        array[lastElement++] = element;
    }

    public Integer dequeue(){
        if(firstElement == lastElement){
            System.out.println("List is empty");
            throw new ArrayIndexOutOfBoundsException();
        }
        if (array.length > maxLength && lastElement - firstElement < minLength){
            Integer[] array2 = new Integer[lastElement - firstElement];
            System.arraycopy(array, firstElement, array2,0,lastElement - firstElement);
            array = array2;
            lastElement = lastElement - firstElement;
            firstElement = 0;
        }
        return array[firstElement++];
    }
    public Integer first(){
        return array[0];
    }

    public void print(){
        StringBuilder sb = new StringBuilder();
        for(int i = firstElement; i < lastElement; i++){
            sb.append(array[i] + " ");
        }
        System.out.println(sb.toString());
    }
}
