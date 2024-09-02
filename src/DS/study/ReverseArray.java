package src.DS.study;

public class ReverseArray {
    public static void main(String[] args) {

        int [] ar = {1,2,3,4,5};

        for(int i = 0 ; i < ar.length ; i++){
            System.out.print(ar[i] + " ");
        }

        for(int i = ar.length-1 ; i >= 0 ; i--){
            System.out.print(ar[i] + " ");
        }

    }
}
