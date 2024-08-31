package src;

import java.util.Scanner;

public class conditions {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter your evaluation grade please :");
        int grade = sc.nextInt();

        if(grade >= 90) {
            System.out.println("Your grade is A");
        }else if(grade >= 80 && grade < 89){
            System.out.println("Your grade is B");
        }

        sc.close();
    }
}