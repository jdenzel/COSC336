import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        String files[] = {"src/input-5.1.txt", "src/input-5.2.txt", "src/input-5.3.txt", "src/input-5.4.txt"};
        for(int i = 0; i < files.length; i++) { // loop through files array 
            int[] fileSet = readFile(files[i]);
            System.out.println("Max Sum: " + maxIncreasingSum(fileSet));
        }
    }
 
    private static int[] readFile(String filePath) { // function to read elements from file
        int[] set = null;
        try {
            Scanner scanner = new Scanner(new File(filePath));
            int length = scanner.nextInt(); // gets length of array
            set = new int[length]; // initialize a new arr
            
            for (int i = 0; i < length; i++) { // copies file elements into the array 
                set[i] = scanner.nextInt(); // reads the next integer from file 
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Cannot be found: " + e.getMessage()); // print event message if file cannot be found
        }
        return set;
    }
    
    public static int maxIncreasingSum(int[] seq) {
        int maxSum = 0;
        int[] s = new int[seq.length]; // maxValues array
        int[] p = new int[seq.length]; // indexes array
        Stack<Integer> stack = new Stack<Integer>();

        for (int i = 0; i < seq.length; i++){   
            p[i] = -1; // initialize values of p array to -1 for reverse checking
            s[i] = seq[i]; // initizlize values of s array to seq[] values
        } 
        for (int i = 1; i < s.length; i++) {
            for (int j = 0; j < i; j++) {
                if (seq[i] >= seq[j] && s[i] < s[j] + seq[i])  { // condition checks if the value at seq[i] is an increasing number for the sequence
                    s[i] = s[j] + seq[i]; // set s[i] to the new increasing value if condition is true
                    p[i] = j; // store the index of when s[i] increases
                }
            }
        }

        for(int i = 0; i < s.length; i++) {
            if (maxSum < s[i]) 
                maxSum = s[i]; // loop through s[i] to get the maximum sum of the s[i] array 
        };

        for(int i = s.length - 1; i != -1; i = p[i]) { 
            stack.push(seq[i]); // push seq[i] values from the saved indexes of p[i]
        }
        // start at end of seq[] i = seq.length - 1 = 5 | seq[5] = 5 | stack = [5]
        // i = p[5] = 3 from p[-1, 0, 0, 2, 0, 3] | seq[3] = 5 | stack = [5, 5]
        // i = p[3] = 2 from p[-1, 0, 0, 2, 0, 3] | seq[2] = 5, | stack =[ 5, 5, 5]
        // i = p[2] = 0 from p[-1, 0, 0, 2, 0, 3] | seq[0] = 1 | stack = [5, 5, 5, 1] 
        // i = p[0] = -1 from p[-1, 0, 0, 2, 0, 3] | i = -1 end loop

        System.out.println("S array: " + Arrays.toString(s));
        System.out.println("P array: " + Arrays.toString(p));
        System.out.println("Stack: " + stack);

        int[] maxSequence = new int[stack.size()];

        for (int i = 0; i < maxSequence.length; i++) {
            maxSequence[i] = stack.pop(); // pop values from stack and return them to maxSequence
        }
        // maxSequence = [] | stack = [5, 5, 5, 1]
        // maxSequence = [1] | stack = [5, 5, 5]
        // maxSequence = [1, 5] | stack = [5, 5]
        // maxSequence = [1, 5, 5] | stack = [5]
        // maxSequence = [1, 5, 5, 5] | stack = []
        
        System.out.println("Maximum increasing sequence: " + Arrays.toString(maxSequence));

        return maxSum;
    }
} 