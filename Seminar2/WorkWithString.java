package Seminar2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class WorkWithString {
    public static void main(String[] args) throws Exception {
        String path = "data.txt";
        task1(path);
    }

    public static void task1(String path) throws Exception {
        List<String> fileData = readFileAndParse(path);
        printText(fileData);
        printText1(fileData);

    }

    static void printText(List<String> fileData){
        StringBuilder sb = new StringBuilder();
        fileData.forEach((data)-> sb.append(PrintLine(data.toString()) +"\n"
        ));
        System.out.println(sb.toString());
    }
    static void printText1(List<String> filData){
        StringBuilder sb = new StringBuilder();
        for(String data : filData){
            sb.append(PrintLine(data) + "\n");
        }
        System.out.println(sb.toString());
    }
    static List<String> readFileAndParse(String path) throws Exception{
        BufferedReader reader = new BufferedReader(new FileReader(path));
        List<String> fileData = new ArrayList<>();
        String str;
        while ((str = reader.readLine()) != null){
            fileData.add(str);
        }
        reader.close();
        return fileData;
    }

    public static StringBuilder PrintLine(String s) {
        s = s.replaceAll("[{\"}]", "");
        s = s.replace("[", "");
        s = s.replace("]", "");
        StringBuilder result = new StringBuilder("");
        String[] arrayData = s.split(",");
        String[] listName = { "Студент ", " получил ", " по предмету " };
        for (int i = 0; i < arrayData.length; i++) {
            String[] arrData = arrayData[i].split(":");
            result.append(listName[i]);
            result.append(arrData[1]);
        }
        return result;
    }
}
