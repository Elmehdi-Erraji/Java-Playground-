package src.DS.study;

public class MoveZero {
    public static void main(String[] args) {

        int[] arr = {1, 2, 0, 3, 4, 5, 0, 6, 0};

        int nonZeroIndex =  0; // To track the position to place non-zero elements

        // First pass: Move non-zero elements to the front
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                arr[nonZeroIndex] = arr[i];
                nonZeroIndex++;
            }
        }
        for(int i = nonZeroIndex; i < arr.length; i++) {
            arr[i] = 0;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

    }
}
