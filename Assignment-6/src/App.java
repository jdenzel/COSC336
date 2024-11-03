class Node {
    int key;
    int size;
    Node left, right;

    public Node(int item, int size1)
    {
        key = item;
        left = right = null;
        size = size1;
    }
}

class App {

    // A utility function to insert a new node
    // with the given key
    static Node insert(Node root, int key, int size)
    {

        // If the tree is empty, return a new node
        if (root == null)
            return new Node(key, size);

        // If the key is already present in the tree,
        // return the node
        if (root.key == key)
            return root;

        // Otherwise, recur down the tree
        if (key < root.key)
            root.left = insert(root.left, key, size);
        else
            root.right = insert(root.right, key, size);

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
            System.out.print("(" + root.key + "," + root.size + ")" + "," + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    // static void leftRotate(Node root) {

    // }

    // static void rightRotate(Node root) {

    // }

    // Driver method
    public static void main(String[] args)
    {
        Node root = null;

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

        root = insert(root, 7, 6);
        root = insert(root, 10, 4);
        root = insert(root, 3, 1);
        root = insert(root, 9, 1);
        root = insert(root, 13, 2);
        root = insert(root, 11, 1);

        // Print inorder traversal of the BST
        preorder(root);
    }
}