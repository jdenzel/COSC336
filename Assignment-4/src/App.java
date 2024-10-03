import java.util.Arrays;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        int[] set1 = {1,5,8,9,10,17,17,20,24,30}; //rod lengths from 1 - 10
        int n = set1.length;
        printCRS(set1, n);

        String files[] = {"Assignment-4/src/input-4.2.txt", "Assignment-4/src/input-4.3.txt"};
        for(int i = 0; i < files.length; i++) { // loop through files array 
            int[] fileSet = readFile(files[i]);
            printCRS(fileSet, fileSet.length - 1);
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

    public static int[] extendedBUCR(int[] p, int n) { // p: array | n: length
        
        int[] r = new int[n + 1]; // initialize r array for storing max revenue for each rod
        int[] s = new int[n + 1]; // initialize s array for storing optimal size of first piece to cut off

        r[0] = 0;
        for(int j = 1; j <= n; j++) { // loops the rod length
            int q = Integer.MIN_VALUE;
            for(int i = 1; i <=j; i++) { // loops the rod cuts
                if(q < (p[i - 1] + r[j - i])) {
                    q = p[i - 1] + r[j - i]; // updates max revenue
                    s[j] = i; // stores best cut solution in array s
                }
            }
            r[j] = q; // store max revenue value
        }
        System.out.println("Cuts: " + Arrays.toString(s));
        System.out.println("Optimal Size of First piece to cutoff: " + Arrays.toString(r));
        System.out.println("Maximum Revenue: " + r[n]);

        return s; // return cuts
    }

    public static void printCRS(int[] p, int n) {
        int[] s = extendedBUCR(p, n);
        System.out.print("Optimal Decomposition: ");
        while(n > 0) {
            System.out.print(s[n] + " "); // prints cut locations for length n
            n = n - s[n]; // sets to the remaining length of the rod
        }
        System.err.println("\n");
    }
}
