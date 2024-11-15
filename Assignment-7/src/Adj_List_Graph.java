import java.util.*;
import java.io.*;

public class Adj_List_Graph {
  int n; // number of nodes
  ArrayList<ArrayList<Integer>> adj;

  // constructor taking as the single parameter the number of nodes

  Adj_List_Graph(int no_nodes, int[] n2_bits) {
    n = no_nodes; // takes the number of nodes parameter
    adj = new ArrayList<ArrayList<Integer>>(n);
    for (int i = 0; i < n; i++) {
      adj.add(new ArrayList<Integer>());
    }
    for (int k = 0; k < n2_bits.length; k++) {
      int i = k / n; // row
      int j = k % n; // column
      if (n2_bits[k] == 1) {
        addEdge(i, j); // add edge if k is found to be = 1
      }
    }

    // Use BFS to check if the adjacent nodes are of length 1 or 2. Adds the nodes
    // to the queue then final loop adds the edges that was stored in the set
    for (int node = 0; node < n; node++) { // iterate through each node
      Set<Integer> newPath = new HashSet<>(); // store nodes that have a path within length 1 or 2
      Queue<Integer> q = new LinkedList<>(); // intialize queue
      q.add(node); // starting node
      int[] d = new int[n]; // initialze array to track distance the starting node and adjacent nodes
      for (int i = 0; i < n; i++) {
        d[i] = -1; // sets unseen nodes to -1. Different from bool[] to track distance
      }
      d[node] = 0; // sets distance of self node u to 0

      while (!q.isEmpty()) { // iterate while queue is not empty
        int current = q.poll(); // poll() dequeues the node
        for (int adjNode : adj.get(current)) {
          if (d[adjNode] == -1) { // if adjacent node is unseen
            d[adjNode] = d[current] + 1; // add distance of current node + 1 to adjacent node
            if (d[adjNode] == 1 || d[adjNode] == 2) { // add the node to the set if the length is 1 or 2
              newPath.add(adjNode);
              q.add(adjNode);
            }
          }
        }
      }
      for (int v : newPath) { // loops through the set to check which nodes have length 1 or 2
        if (d[v] == 2 || d[v] == 1) {
          addEdge(node, v); // addEdge to the node if it meets the condition
        }
      }
    }
  }

  // A utility function to add an edge in an
  // undirected graph; for directed graph remove the second line
  public void addEdge(int u, int v) {
    if (!adj.get(u).contains(v)) { // checks if node already has an edge. So there are no duplicates
      adj.get(u).add(v);
      // adj.get(v).add(u); //this line should be un-commented, if graph is undirected
    }

  }
  // A utility function to print the adjacency list
  // representation of graph

  public void printGraph() {
    for (int i = 0; i < n; i++) {
      System.out.println("\nAdjacency list of vertex: " + i);
      System.out.print("head");
      for (int j = 0; j < adj.get(i).size(); j++) {
        System.out.print(" -> " + adj.get(i).get(j));
      }
      System.out.println();
    }
  }
}
