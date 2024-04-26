package Lec28;

public class SearchBST {

    static class Node {

        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static Node insert(Node root, int val) {
        if (root == null) {
            root = new Node(val);
            return root;
        }

        if (root.data > val) {
            //left subtree
            root.left = insert(root.left, val);
        }

        if (root.data < val) {
            //right subtree
            root.right = insert(root.right, val);
        }

        return root;
    }

    public static void inorder(Node root) {
        if (root == null) {
            return;
        }

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static boolean search(Node root, int val) {
        if (root == null) {
            return false;
        }

        if (root.data == val) {
            return true;
        }

        if (val < root.data) {
            return search(root.left, val);
        } else {
            return search(root.right, val);
        }

    }

    public static void main(String[] args) {
        // int values[] = { 5, 1, 3, 4, 2, 6 };
        int values[] = { 9, 2, 7, 8, 4, 1, 6, 10 };
        Node root = null;

        for (int i = 0; i < values.length; i++) {
            root = insert(root, values[i]);
        }

        int val = 4;
        System.out.println(search(root, val));
    }
}
