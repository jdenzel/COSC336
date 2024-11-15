import java.util.*;
import java.io.*;
import java.io.File;
import java.io.FileNotFoundException;


//simple Driver program to test Adj_List_Graph class

public class Test_Adj{

  private static int[] readFile(String filePath) { // function to read elements from file
    int[] set = null;
    try {
        Scanner scanner = new Scanner(new File(filePath));
        int nodeAmount = scanner.nextInt(); // gets # of nodes of array
        int nodeAmountArraySize = nodeAmount * nodeAmount; // node ^ 2
        set = new int[nodeAmountArraySize]; // initialize a new arr
        
        for (int i = 0; i < set.length; i++) { // copies file elements into the array 
            set[i] = scanner.nextInt(); // reads the next integer from file 
        }
        scanner.close();
    } catch (FileNotFoundException e) {
        System.out.println("Cannot be found: " + e.getMessage()); // print event message if file cannot be found
    }
    return set;
}
    
  public static void main(String[] args)
  {
    String files[] = {"Assignment-7/src/input-7-1.txt", "Assignment-7/src/input-7-2.txt"};
    for (String file : files) { // loop through files array
      int[] n2_bits = readFile(file);
      int V = (int) Math.sqrt(n2_bits.length); // calculate the number of nodes
      Adj_List_Graph a = new Adj_List_Graph(V, n2_bits);
      System.out.println(" \n G^2 Graph: ");
      a.printGraph();
    } 
  }
}

// int V=4;  
// int[] n2_bits = {0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0};
// Adj_List_Graph a = new Adj_List_Graph(V, n2_bits);

// int V= 3;
// int[] n2_bits = {0, 1, 0, 0, 0, 1, 0, 0, 0 };
// Adj_List_Graph a = new Adj_List_Graph(V, n2_bits);

// int V= 5;
// int[] n2_bits = {0, 1, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 };
// Adj_List_Graph a = new Adj_List_Graph(V, n2_bits);

// Creating a graph with 5 vertices
  // Adding edges one by one
//  a.addEdge(0, 1);
//  a.addEdge(0, 4);
//  a.addEdge(1, 2);
//  a.addEdge(1, 3);
//  a.addEdge(1, 4);
//  a.addEdge(2, 3);
//  a.addEdge(3, 4);

// a.printGraph();

// get inputs from the file
// first line is the # of nodes
// 2nd line is the bits n^2 with 1 being an edge and 0 no edge
// Get the inputs and implement it in the graph G1
// Use the G1 graph and implement G2 graph. 
// Check the nodes that have a path with length 1 or 2
// Create an edge from those nodes
// Print the G2 graph with the extra edges 
// Compute the given 2nd line and to give us the new edges
// k is the index

