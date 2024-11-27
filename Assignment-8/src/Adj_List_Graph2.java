import java.util.*;
import java.io.*;

  public class Adj_List_Graph2{
    int n;  // no of nodes
    int[] dist;
    int[] npath;
    ArrayList<ArrayList<Integer> > adj; 
    //constructor taking as the single parameter the number of nodes
    Adj_List_Graph2(int no_nodes) {
      n = no_nodes;
      adj =  new ArrayList<ArrayList<Integer> >(n);
      for (int i = 0; i < n; i++) {
        adj.add(new ArrayList<Integer>());
      }
    }

    void addEdgeG1() {
      addEdge(1, 2);
      addEdge(1, 4);
      addEdge(1, 3);
      addEdge(2, 5);
      addEdge(3, 5);
      addEdge(4, 6);
      addEdge(5, 6);
      addEdge(5, 7);
      addEdge(6, 7);
    }

    void addEdgeG2() {
      addEdge(1, 2);
      addEdge(1, 3);
      addEdge(1, 4);
      addEdge(1, 5);
      addEdge(1, 6);
      addEdge(2, 7);
      addEdge(3, 7);
      addEdge(4, 7);
      addEdge(5, 7);
      addEdge(6, 7);
      addEdge(7, 8);
      addEdge(7, 9);
      addEdge(8, 10);
      addEdge(9, 10);
    }

    public void shortestPath(int s, int v) {
      // BFS for finding shortest path from s to v
      Queue<Integer> q = new LinkedList<>(); // intialize queue
      q.add(s); // starting node
      dist = new int[n]; // initialze array to track distance of starting node to the current node
      npath = new int[n]; // initialize array to track number of shortest paths based on current node
      for (int i = 1; i < n; i++) {
        dist[i] = -1; // sets unseen nodes to -1. Different from bool[] to track distance
        npath[i] = 0; // sets all paths for each node to 0
      }
      dist[s] = 0; // sets distance of self node u to 0
      npath[s] = 1; // sets starting node number of paths to 1

      while (!q.isEmpty()) { // iterate while queue is not empty
        int current = q.poll(); // poll() dequeues the node
        for (int adjNode : adj.get(current)) {
          if (dist[adjNode] == -1) { // if node is unseen
            dist[adjNode] = dist[current] + 1; // set distance of adjacent node to distance of current node + 1 to indicate it has been seen
            q.add(adjNode); // adds adjacent node to the queue
            npath[adjNode] = npath[current]; // since the adjacent node has not been seen, it will be set to number of paths of current
          }
          else if (dist[adjNode] == dist[current] + 1) { 
            npath[adjNode] += npath[current]; // since adjacent node has been seen, add number of paths of adjacent nodes to number of paths of current node
          }
        }
      }
    }

    // A utility function to add an edge in an
    // undirected graph; for directed graph remove the second line
    public void addEdge(int u, int v)
    {
      adj.get(u).add(v);
      adj.get(v).add(u);  //this line should be un-commented, if graph is undirected
    }
    
    public void printGraph()
    {
      for (int i = 1; i < n; i++) {
        System.out.println("\nAdjacency list of vertex " + i);
        System.out.print(i);
        // System.out.print("head");
        for (int j = 0; j < adj.get(i).size(); j++) {
          System.out.print(" - "+adj.get(i).get(j));
        }
        System.out.println();
      }
    }
  }


  
  
