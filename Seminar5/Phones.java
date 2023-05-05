package Seminar5;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Phones {
    private Map<String, List<String>> person;

    public Phones(Map<String, List<String>> person) {
        this.person = person;
    }

    public Phones() {
    }

    public void add(String lastName, String number){
        if (person.containsKey(lastName)){
            person.get(lastName).add(number);
        } else {
            List<String> phones = new ArrayList<>();
            phones.add(number);
            person.put(lastName, phones);
        }
    }
    public String getPhoneNumber(String name){
        StringBuilder res = new StringBuilder();
        if (person.containsKey(name)){
            res.append(name + ":\n");
            for (int i = 0; i < person.get(name).size(); i++) {
                res.append((i+1) + ") " + person.get(name).get(i) + "\n");
            }
        } else{
            res.append("There is no person in the phone book");
        }
        return res.toString();
    }

    public String getByPhoneNumber(String number){
        String res = "No such number\n";
        for(Map.Entry<String,List<String>> entry: person.entrySet()){
            if (entry.getValue().contains(number)){
                res = entry.getKey() + " has number " + number + "\n";
                return res;
            }
        }
        return res;
    }

     public String print(){
         StringBuilder sb = new StringBuilder();
         person.forEach((key, value)-> sb.append(key + " -> " + value + "\n"));
         return sb.toString();
    }
}
