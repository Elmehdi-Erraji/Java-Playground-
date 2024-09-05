package src;
import java.util.Scanner;
public class loops {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("you want to count until where ? :");
        int number = sc.nextInt();

       /* for (int i = 0 ; i <= number ; i++) {
            System.out.print(i);
            System.out.println();
        }*/

        int i = 0;

       /* while (i <= number) {
            System.out.println(i);
            i++;

        }*/

        do {
            System.out.println(i);
            i++;
        }while (i < number);

        sc.close();

    }
}
