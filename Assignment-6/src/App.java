import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Node {
    int key, size;
    Node left, right, parent;

    public Node(int item)
    {
        key = item;
        left = right = parent = null;
        size = 1;
    }
}

class App {

    // A utility function to insert a new node
    // with the given key
    static Node insert(Node root, int key)
    {

        // If the tree is empty, return a new node
        if (root == null)
            return new Node(key);

        // If the key is already present in the tree,
        // return the node
        if (root.key == key)
            return root;

        // Otherwise, recur down the tree
        if (key <= root.key) // if the key is equal to the root key, put it in the left subtree
            root.left = insert(root.left, key);
        else
            root.right = insert(root.right, key);

       root.size = updateSize(root);
        
        // Return the (unchanged) node pointer
        return root;
    }

    // A utility function to do inorder tree traversal
    static void inorder(Node root)
    {
        if (root != null) {
            inorder(root.left);
            System.out.print("(" + root.key + "," + root.size + ")" +  " ");
            inorder(root.right);
        }
    }

    static void preorder(Node root)
    {
        if (root != null) {
            System.out.print("(" + root.key + "," + root.size + ")" +  " ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    private static int updateSize(Node root) {
        int leftSize = 0;
        int rightSize = 0;

        // Condition to check if left and right of node are not empty
        if(root.left != null) {
            leftSize = root.left.size;
        }
        if(root.right != null) {
            rightSize = root.right.size;
        }

        int rootSize = 1 +  leftSize + rightSize; // add the current node size with the left and right node size

        return rootSize;

    }

    static Node leftRotate(Node x) {
        Node y = x.right; // y is x's right subtree
        x.right = y.left; // turn y’s left subtree into x ’s right subtree

        if(y.left != null) { // if y ’s left subtree is not empty
            y.left.parent = x; // . . . then x becomes the parent of the subtree’s root
        }

        y.parent = x.parent; // x ’s parent becomes y ’s parent
        if(x.parent == null) { // if x was the root 
            // x = y; // . . . then y becomes the root
        } else if(x == x.parent.left) { // otherwise, if x was a left child 
            x.parent.left = y; // . . . then y becomes a left child
        } else { 
            x.parent.right = y; // otherwise, x was a right child, and now y is
        }
        y.left = x; // make x become y ’s left child
        x.parent = y;  

        x.size =  updateSize(x);
        y.size =  updateSize(y);
        return y;
    }

    static Node rightRotate(Node x) {
        Node y = x.left; // y is x's left subtree
        x.left = y.right; // turn y’s right subtree into x ’s left subtree

        if(y.right != null) { // if y ’s right subtree is not empty
            y.right.parent = x; // . . . then x becomes the parent of the subtree’s root
        }

        y.parent = x.parent; // x ’s parent becomes y ’s parent
        if(x.parent == null) { // if x was the root 
            // x = y; // . . . then y becomes the root
        } else if(x == x.parent.right) { // otherwise, if x was a right child 
            x.parent.right = y; // . . . then y becomes a right child
        } else { 
            x.parent.left = y; // otherwise, x was a left child, and now y is
        }
        y.right = x; // make x become y ’s right child
        x.parent = y;  

        x.size =  updateSize(x);
        y.size =  updateSize(y);
        return y;
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

    // Driver method
    public static void main(String[] args)
    {
        Node root = null;
        int[] testData = {7, 10, 3, 9, 13, 11};

        for (int value : testData) {
            root = insert(root, value);
        }

        // Print preorder traversal of the BST
        System.out.println("Preorder before rotation:");
        preorder(root); // Expected output: (7,6), (3,1), (10,4), (9,1), (13, 2), (11,1)
        root = leftRotate(root);
        System.out.println();
        System.out.println("Preorder after rotation:");
        preorder(root); // After rotation Expected output: (10,6), (7,3), (3,1), (9,1) (13,2), (11, 1).
        System.out.println();

        String files[] = {"Assignment-6/src/input-6-1.txt", "Assignment-6/src/input-6-2.txt"};
        for(int i = 0; i < files.length; i++) { // loop through files array 
            int[] fileSet = readFile(files[i]);
            Node root2 = null;
            for (int value : fileSet) {
                root2 = insert(root2, value);
            }
            System.out.println("Preorder before:");
            preorder(root2);
            System.out.println();
            root2 = leftRotate(root2);
            System.out.println("Preorder after rotation:");
            preorder(root2);
            System.out.println();
        }
    }
}
// Starting BST
        //      7
        //     /  \
        //    3   10
        //        / \
        //        9  13
        //          /
        //         11

        // After preorder traversal and leftRotate
        //      10
        //     /  \
        //    7   13
        //   / \  /
        //  3  9 11 