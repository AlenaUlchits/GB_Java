package Seminar5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
import java.util.logging.FileHandler;
import java.util.logging.Logger;


public class WorkWithMap {
    public static void main(String[] args) throws Exception{
       // task1();
        task2();
    }

    private static void task1() {
        Map<String, List<String>> person = new HashMap<>();
        List<String> phones = new ArrayList<>();
        phones.add("+375294862564");
        phones.add("+459651254786");
        person.put("Ivanov Ivan", phones);
        Phones phoneBook = new Phones(person);
        phoneBook.add("Siarhey Sergeich", "+9854736214");
        phoneBook.add("Victor Victorovich", "8(033)1547698");
        phoneBook.add("Siarhey Sergeich", "8(017)1254361");
        System.out.println(phoneBook.print());
        System.out.println(phoneBook.getByPhoneNumber("+9854736214"));
        System.out.println(phoneBook.getPhoneNumber("Ivanov Ivan"));
    }

    private static void task2() throws Exception{
        String path = "names.txt";
        List<String> fileData = readFileAndParse(path);
        Map<Integer,List<String>> map = convertListToMap(fileData);
        printMap(map);

    }

    static List<String> readFileAndParse(String path) throws Exception{
        Logger logger = Logger.getLogger(WorkWithMap.class.getName());
        FileHandler fh = new FileHandler("logMap.txt");
        logger.addHandler(fh);
        List<String> fileData = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            String str;
            while ((str = reader.readLine()) != null) {
                fileData.add(str.replaceAll("[{\"}]", "")
                        .replace("[", "")
                        .replace("]", ""));
            }
            reader.close();
            logger.info("File data were transformed");
        }catch (Exception e){
            logger.info("Not possible to read a file");
        }
        fh.close();
        return fileData;
    }

    static Map<Integer, List<String>> convertListToMap(List<String> names){
        Map<Integer,List<String>> map = new TreeMap<>(Comparator.reverseOrder());
        for (int i = 0; i < names.size(); i++) {
            String[] surname = names.get(i).split(" ");
            if (isName(map,surname[0])){
                int key = getKey(map,surname[0]);
                map.get(key).remove(surname[0]);
                if (map.containsKey(++key)){
                    map.get(key).add(surname[0]);
                } else {
                    List<String> namesList = new ArrayList<>();
                    namesList.add(surname[0]);
                    map.put(key, namesList);
                }
            } else {
                if(map.isEmpty()){
                    List<String> namesList = new ArrayList<>();
                    namesList.add(surname[0]);
                    map.put(1, namesList);
                } else {
                    map.get(1).add(surname[0]);
                }
            }
        }
        return map;
    }

    static boolean isName (Map<Integer,List<String>> map, String name){
        for(int x: map.keySet()){
            if(map.get(x).contains(name)){
                return true;
            }
        }
        return false;
    }

    static int getKey (Map<Integer,List<String>> map, String name){
        for (Map.Entry<Integer,List<String>> entry: map.entrySet()){
            if (entry.getValue().contains(name)){
                return entry.getKey();
            }
        }
        return 0;
    }
    static void printMap(Map<Integer, List<String>> names){

        for (Map.Entry<Integer,List<String>> entry: names.entrySet()){
            if(entry.getKey() > 1)
                System.out.println(entry.getValue().toString().replace("[", "")
                        .replace("]", "") + " repeat " +
                        entry.getKey() + " times\n");
        }
    }

}
