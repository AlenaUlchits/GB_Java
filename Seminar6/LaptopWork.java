package Seminar6;

import java.util.*;

public class LaptopWork {
    public static void main(String[] args){
        Set<Laptop> laptops = new HashSet<>();
        laptops.add(new Laptop(4,1024, "Windows", "Grey"));
        laptops.add(new Laptop(8,2048, "MacOS", "Purple"));
        laptops.add(new Laptop(4,1024, "Linux", "Black"));
        laptops.add(new Laptop(16,2048, "Windows", "Grey"));
    

        Set<Laptop> set = filter(laptops);
        System.out.println("Filtered notebooks: ");
        for(Laptop noteBook: set)
            System.out.println(noteBook);
    }

    public static Set<Laptop> filter (Set<Laptop> set){
        Map<Integer,String> filters = getMinValues(getFilters(set));
        Set<Laptop> filterSet = new HashSet<>();
        boolean condition = false;
        for (Laptop noteBook: set){
            for (Map.Entry<Integer, String> el: filters.entrySet()){
                switch (el.getKey()){
                    case 1: condition = Integer.parseInt(el.getValue()) <= noteBook.getRam(); break;
                    case 2: condition = Integer.parseInt(el.getValue()) <= noteBook.getHdd(); break;
                    case 3: condition = el.getValue().equals(noteBook.getOs()); break;
                    case 4: condition = el.getValue().equals(noteBook.getColor());
                }
                if (!condition) break;
            }
            if (condition) {
                filterSet.add(noteBook);
            }
        }
        return filterSet;
    }

    private static Map<Integer,String> getFilters(Set<Laptop> set){
        String menu = "Enter number, that suits to your filters\n" +
                "1 - RAM\n" +
                "2 - HDD\n" +
                "3 - OS\n" +
                "4 - Color\n" +
                "0 - Exit";
        Map<Integer,String> map = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
            System.out.println(menu);
            int filter = scanner.nextInt();
            scanner.nextLine();
            while(filter != 0) {
                if (filter <= 4 && filter > 0){
                    map.put(filter, "");
                    System.out.println(menu);
                    filter = scanner.nextInt();
                    scanner.nextLine();
                } else {
                    System.out.println("Incorrect input");
                    System.out.println(menu);
                    filter = scanner.nextInt();
                    scanner.nextLine();
                }
            }
        return map;

    }

    private static Map<Integer,String> getMinValues(Map<Integer,String> map){
        System.out.println("Enter (min) value for search");
        Scanner scanner = new Scanner(System.in);
        for (Map.Entry<Integer, String> x: map.entrySet()){
            System.out.print(x + " ");
            if (scanner.hasNext())
                x.setValue(scanner.nextLine());
        }
        return map;
    }

}
