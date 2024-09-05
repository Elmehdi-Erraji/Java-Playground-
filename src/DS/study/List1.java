package src.DS.study;

import java.security.spec.RSAOtherPrimeInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class List1 {

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();

        int sum=0;

        numbers.add(5);
        numbers.add(10);
        numbers.add(15);


        for (Integer number : numbers) {
            sum = number + number;
            System.out.println(number);
        }
        System.out.println("list numbers sum is : "  + sum);
        numbers.remove(Integer.valueOf(10));

        System.out.println("the updated list is :");
        for (Integer number : numbers) {
            System.out.println(number);
        }

        Map<String,Integer> map = new HashMap<>();

        map.put("John",12);
        map.put("Jane",22);
        map.put("Jack",13);

        for (Map.Entry<String,Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }




    }
}
