import java.util.*;
import java.io.*;


//simple Driver program to test Adj_List_Graph class

public class Test_Adj2{
    
  public static void main(String[] args)
  {
    int nodesG1 = 7;
    Adj_List_Graph2 G1 = new Adj_List_Graph2(nodesG1 + 1);
    G1.addEdgeG1(); // adds edges to graph
    G1.printGraph(); // prints adjacency graph
    G1.shortestPath(1, nodesG1);  // prints the shortest path distance and number of shortest path of each node
    System.out.println("Array of distances from start node " + Arrays.toString(G1.dist));
    System.out.println("Array of shortest paths from start node " + Arrays.toString(G1.npath));
    System.out.println("\ndist[" + nodesG1 + "]" + " = " + G1.dist[nodesG1]);
    System.out.println("npath[" + nodesG1 + "]" + " = " + G1.npath[nodesG1]);

    // Nodes                                          [0, 1, 2, 3, 4, 5, 6, 7]
    // Distances of each node from start (1)         [-1, 0, 1, 1, 1, 2, 2, 3]
    // Shortest path of each node from start (1)      [0, 1, 1, 1, 1, 2, 1, 3]
    

    int nodesG2 = 10;
    Adj_List_Graph2 G2 = new Adj_List_Graph2(nodesG2 + 1);
    G2.addEdgeG2(); // adds edges to graph
    G2.printGraph(); // prints adjacency graph
    G2.shortestPath(1, nodesG2); // prints the shortest path distance and number of shortest path of each node
    System.out.println("Array of distances from start node " + Arrays.toString(G2.dist));
    System.out.println("Array of shortest paths from start node " + Arrays.toString(G2.npath));
    System.out.println("\ndist[" + nodesG2 + "]" + " = " + G2.dist[nodesG2]);
    System.out.println("npath[" + nodesG2 + "]" + " = " + G2.npath[nodesG2]);
    

    // Nodes                                          [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
    // Distances of each node from start (1)         [-1, 0, 1, 1, 1, 1, 1, 2, 3, 3, 4]
    // Shortest path of each node from start (1)      [0, 1, 1, 1, 1, 1, 1, 5, 5, 5, 10]
    
  }
}