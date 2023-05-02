package Seminar3;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class WorkWithArray {
    public static void main(String[] args){
        List<Integer> numberList = createList();
        printArray(numberList);
        task1(numberList);
        task2(numberList);
        task3();
    }

    static List<Integer> createList(){
        List<Integer> numbersList = new ArrayList<>();
        Random rand = new Random();
        int size = rand.nextInt(3,13);
        for(int i = 0; i < size; i++){
            numbersList.add(rand.nextInt(1, 10));
        }
        return numbersList;
    }

    static void task1(List<Integer> numbers){
        for(int i = 0; i < numbers.size(); i++){
            if(numbers.get(i) % 2 == 0){
                numbers.remove(i);
            }
        }
        printArray(numbers);
    }

    static void printArray(List<Integer> numbers){
        StringBuilder sb = new StringBuilder();
        numbers.forEach((number)-> sb.append(number.toString() +" "
        ));
        System.out.println(sb.toString());
    }

    static void task2(List<Integer> numbers){
        Integer max = numbers.get(0), min = numbers.get(0), sum = 0;
        max = Collections.max(numbers);
        min = Collections.min(numbers);
        for(Integer num : numbers){
            sum += num;
        }
        float average = (float)sum/numbers.size();

        System.out.println("Max elem = " + max + ", min elem = " + min + ", average elem = " + average);
    }

    static void task3(){
        String[] planets = {"Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune",  "Jupiter", "Saturn",
                "Venus", "Earth","Venus", "Earth"};
        List<String> planetsList = Arrays.asList(planets);
        for(int i = 0; i < planetsList.stream().distinct().collect(Collectors.toList()).size(); i++){
            System.out.println(planetsList.get(i) + " -> " +Collections.frequency(planetsList, planetsList.get(i)));
        }

        /* planetsList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).
                entrySet().stream().forEach(e -> System.out.println(e.getKey() + " -> " + e.getValue()));
        Map<String, Integer> planetMap = new HashMap<>();
        String planet;
        int count;
        for(String pl : planetsList){
            planet = pl;
            count = 0;
            for(String p : planetsList) {
                if (planet.equals(p)) {
                    count++;
                }
            }
            planetMap.put(planet, count);
        }
        printMap(planetMap);*/

    }
    static void printMap(Map<String, Integer> planets){
        StringBuilder sb = new StringBuilder();
        planets.forEach((key, value)-> sb.append(key + " -> " + value + "\n"));
        System.out.println(sb.toString());
    }
}
