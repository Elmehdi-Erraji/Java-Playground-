package src.DS.study;

import java.util.*;

import java.util.Scanner;
public class List2 {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<Integer>();

        list.add(1);
        list.add(4);
        list.add(6);
        list.add(9);
        list.add(112);

        System.out.println(findMaxValue(list));

        List<String> words = new ArrayList<>();
        words.add("cat");
        words.add("dog");
        words.add("amin");
        words.add("mehdi");
        words.add("panda");

        String Sortedwords = sortInAlphabetOrder(words);

        System.out.println(Sortedwords);


        Map<String, Integer> studentGrade = new HashMap<>();

        studentGrade.put("mehdi",12);
        studentGrade.put("anas",13);
        studentGrade.put("amin",15);
        studentGrade.put("rachid",17);

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name of students you want to find his grade: ");
        String name = sc.nextLine();

        System.out.println("The grade of the user is : " + studentGradeFinder(studentGrade,name));
    }
    public static int findMaxValue(List<Integer> list){
        if(list == null || list.isEmpty()){
            return 0 ;
        }
        int max = list.get(0);
        for(int i=1;i<list.size();i++){
            if(list.get(i)>max){
                max = list.get(i);
            }
        }
        return max;
    }

    public static String sortInAlphabetOrder(List<String> words){
        if(words == null || words.isEmpty()){
            return "emptylist";
        }

        Collections.sort(words);

        return String.join(" ", words);

    }

    public static int studentGradeFinder(Map<String, Integer> studentGrade, String name){

        if(studentGrade == null || studentGrade.isEmpty()){
            return 111;
        }

       if(studentGrade.containsKey(name)){
           return studentGrade.get(name);
       }else {
           return 0;
       }


    }
}
