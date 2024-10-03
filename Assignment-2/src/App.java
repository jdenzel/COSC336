public class App {
    public static void main(String[] args) throws Exception {
        int[] seq1 = { 10, 9, 2, 5, 3, 101, 7, 18 };
        System.out.println("Longest increasing subsequence: " + incSubSeq(seq1));
        int[] seq2 = { 186, 359, 274, 927, 890, 520, 571, 310, 916, 798, 732, 23, 196, 579,
            426,188, 524, 991, 91, 150, 117, 565, 993, 615, 48, 811, 594, 303, 191,
            505, 724, 818, 536, 416, 179, 485 , 334 , 74, 998, 100, 197, 768, 421,
            114, 739, 636, 356, 908 , 477, 656 };
        System.out.println("Longest increasing subsequence: " + incSubSeq(seq2));
        int[] seq3 = {  318 , 536 , 390 , 598 , 602 , 408 , 254 , 868 , 379 , 565 , 206 , 619 , 936 , 195 ,
            123 , 314 , 729 , 608 , 148 , 540, 256 , 768 , 404 , 190 , 559 , 1000 , 482 , 141 , 26,
            230 , 550 , 881 , 759 , 122 , 878, 350, 756, 82, 562, 897, 508, 853, 317 ,
            380 , 807 , 23 , 506 , 98 , 757 , 247 };
        System.out.println("Longest increasing subsequence: " + incSubSeq(seq3));
    }

    public static int incSubSeq(int[] seq) {
;
        int[] mem = new int[seq.length]; // Memoization. Storage of results of the subproblem. This will track our largest increasing subsequence
        int max = 1;

        for (int i = 0; i < seq.length; i++) // All values of mem initialized to 1 
            mem[i] = 1;

        for (int i = 1; i < seq.length; i++) // Loops through each element of the array starting at index [1]
            for (int j = 0; j < i; j++) // Loops through indexes [i-1] after every iteration of i. So if i = 1, the loop will only go up until j[0] until i increments from the outer loop.
                if (seq[i] > seq[j] && mem[i] < mem[j] + 1) { // checks to see if seq[i] is > seq[i-1] and our storage mem[i] < mem[i] + 1.
                    mem[i] = mem[j] + 1; // if condition is true, current index[i] of mem will update to mem[i-1] + 1
                
                }
        for (int i = 0; i < mem.length; i++)
            if(max < mem[i]) { 
                max = mem[i]; // Loops through mem[] to find the max increasing subsequence
            }
            

        return max;
    }
} 