import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;

public class Assignment3 {
    public static void main(String[] args) throws Exception {
        
        int[] arr = {7,3,8,1,5};
        System.out.println("Before Mergesort: " + Arrays.toString(arr));
        int uppairs = mergeSort(arr, 0, arr.length - 1);
        System.out.println("After Mergesort: " + Arrays.toString(arr));
        System.out.println("UPPairs Array 1: " + uppairs);

        String files[] = {"Assignment-3/src/input-3.4.txt", "Assignment-3/src/input-3.5.txt"};
        for(int i = 0; i < files.length; i++) { // loop through files array 
            int[] fileArr = readFile(files[i]);
            int fileUPPairs = mergeSort(fileArr, 0, fileArr.length - 1);
            mergeSort(fileArr, 0, fileArr.length - 1);
            System.out.println("UPPairs Array " + (i + 2) + ": " + fileUPPairs);
            // System.out.println(Arrays.toString(fileArr));
        }
        
    }

    private static int[] readFile(String filePath) { // function to read elements from file
        int[] arr = null;
        try {
            Scanner scanner = new Scanner(new File(filePath));
            int length = scanner.nextInt(); // gets length of array
            arr = new int[length]; // initialize a new arr
            
            for (int i = 0; i < length; i++) { // copies file elements into the array 
                arr[i] = scanner.nextInt(); // reads the next integer from file 
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Cannot be found: " + e.getMessage()); // print event message if file cannot be found
        }
        return arr;
    }

    private static int mergeSort(int[] arr, int p, int r) { // p: left index r: right index | Ex: Array 1: [7, 3, 8, 1, 5] p = 0, r = 4
        int UPPairs = 0; 
        if(p < r) {
            int q = (p+r)/2; // q: mid index
            UPPairs += mergeSort(arr, p, q);    // recursively calls to divide and sort the left half of array from (indexes p to q)and counts the number of UPPairs during merge function call
            UPPairs += mergeSort(arr, q + 1, r); // recursively calls to divide and sort the right half of array from (indexes q+1 to r) and counts the number of UPPairs during merge function call
            UPPairs += merge(arr, p, q, r);    // combines the left and right halves and counts the uppairs during the process
        } // recursion of mergeSort will end once left index is less than right index
        return UPPairs;
    }

    private static int merge(int[] arr, int p, int q, int r) { // int q: mid index
        int leftLength = q - p + 1;
        int rightLength = r - q;

        int[] leftArr = new int[leftLength]; // initialize leftArr 
        int[] rightArr = new int[rightLength]; // initialize rightArr 

        for(int i = 0; i <= leftLength - 1; i++) { // copy elements to leftArr
            leftArr[i] = arr[p+i];
        }
        for(int j = 0; j <= rightLength - 1; j++) { // copy elements to rightArr
            rightArr[j] = arr[q + j + 1];
        }

        int i = 0;
        int j = 0;
        int k = p;
        int UPPairs = 0;

        while(i < leftLength && j < rightLength) { // merges values from least to greatest
            if(leftArr[i] <= rightArr[j]) {
                UPPairs += (rightLength - j); // increase count of uppair if leftArr value is less than or equal to rightArr value
                arr[k] = leftArr[i];
                i = i + 1;
            }
            else {
                arr[k] = rightArr[j];
                j = j + 1;
            }
            k = k + 1;
        }
    
        while(i < leftLength) { // After going through leftArr and rightArr, copy the remainding values into the merged arr
            arr[k] = leftArr[i];
            i = i + 1;
            k = k + 1;
        }
        while(j < rightLength) {
            arr[k] = rightArr[j];
            j = j + 1;
            k = k + 1;
        }

        return UPPairs;
    }
}
