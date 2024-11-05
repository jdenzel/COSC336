class Node {
    int key;
    Node left, right;
    int size; // Keeps track of the size of the subtree rooted at this node

    public Node(int key) {
        this.key = key;
        this.size = 1; // Size is 1 when node is created (itself)
        this.left = this.right = null;
    }
}

class BinarySearchTree {
    Node root;

    public BinarySearchTree() {
        root = null;
    }

    // Insert method that allows duplicates (duplicates go to the left subtree)
    public Node insert(Node node, int key) {
        if (node == null) {
            return new Node(key);
        }

        if (key <= node.key) {
            node.left = insert(node.left, key);
        } else {
            node.right = insert(node.right, key);
        }

        // Update size of this node
        node.size = 1 + getSize(node.left) + getSize(node.right);
        return node;
    }

    // Helper method to get the size of a node (returns 0 if node is null)
    private int getSize(Node node) {
        return (node == null) ? 0 : node.size;
    }

    // Left rotate around given node
    public Node leftRotate(Node node) {
        if (node == null || node.right == null) {
            return node;
        }

        Node newRoot = node.right;
        node.right = newRoot.left;
        newRoot.left = node;

        // Update sizes
        node.size = 1 + getSize(node.left) + getSize(node.right);
        newRoot.size = 1 + getSize(newRoot.left) + getSize(newRoot.right);

        return newRoot;
    }

    // Right rotate around given node
    public Node rightRotate(Node node) {
        if (node == null || node.left == null) {
            return node;
        }

        Node newRoot = node.left;
        node.left = newRoot.right;
        newRoot.right = node;

        // Update sizes
        node.size = 1 + getSize(node.left) + getSize(node.right);
        newRoot.size = 1 + getSize(newRoot.left) + getSize(newRoot.right);

        return newRoot;
    }

    // Preorder traversal to print nodes and their sizes
    public void preorder(Node node) {
        if (node != null) {
            System.out.print("(" + node.key + ", " + node.size + ") ");
            preorder(node.left);
            preorder(node.right);
        }
    }

    // Insert values from an array into the tree
    public void insertValues(int[] values) {
        for (int value : values) {
            root = insert(root, value);
        }
    }

    // Perform left rotation on the root
    public void rotateRootLeft() {
        root = leftRotate(root);
    }

    // Perform right rotation on the root
    public void rotateRootRight() {
        root = rightRotate(root);
    }
}

public class test {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        int[] testData = {7, 10, 3, 9, 13, 11};

        // Insert values
        bst.insertValues(testData);

        // Preorder traversal before rotation
        System.out.println("Preorder traversal before left rotation:");
        bst.preorder(bst.root);
        System.out.println();

        // Perform left rotation at root
        bst.rotateRootLeft();

        // Preorder traversal after left rotation
        System.out.println("Preorder traversal after left rotation:");
        bst.preorder(bst.root);
        System.out.println();
    }
}
