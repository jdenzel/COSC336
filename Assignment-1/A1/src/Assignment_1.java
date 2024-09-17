import java.util.*;

public class Assignment_1 {
    // ------------------------------------------------------------//
    public static int NumSequence(int[] arr) {
        if (arr.length == 0)
            return 0;
        int length_1 = 1; // This is the current length of the sequence
        int maxLength = 1;
        // ------------------------------------------------------------//
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1]) {
                length_1++;
            } else {
                length_1 = 1; // This resets the counter so that the length cannot go past the sequence's cap
            }
            if(maxLength < length_1) { 
                maxLength = length_1; // sets maxLength to the length_1 if the value of maxLength is less length_1
            }
        }
        return maxLength;
    }

    // ------------------------------------------------------------//
    public static int[] RandomNumber(int size) { // This generates a random amount of numbers to be used in a sequence
        Random num = new Random();
        int[] randomNum = new int[size];
        for (int i = 0; i < size; i++) {
            randomNum[i] = num.nextInt(2); // This actually places the randomly generated
        }
        return randomNum;
    }

    // ------------------------------------------------------------//
    public static void main(String[] args) { // This is our main method that prints out the results we recieve from the
                                             // sequences
        int[] Num1 = { 2, 5, 5, 1, 11, 11, 11, 3, 5, 5, 5, 5, 4, 7 };
        System.out.println("The subsequence in Num1: " + NumSequence(Num1));
        int[] Num2 = { 1, 0, 0, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 0, 1,
                0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1 };
        System.out.println("The subsequence in Num2: " + NumSequence(Num2));
        int[] Num3 = { 1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 1, 1, 1, 1,
                1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2 };
        System.out.println("The subsequence in Num3: " + NumSequence(Num3));
        int[] RandomNum = RandomNumber(4000);
        System.out.println("The subsequence in Num4: " + NumSequence(RandomNum));
    }
}
