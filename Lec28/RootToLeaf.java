package Lec28;

import java.util.ArrayList;

public class RootToLeaf {

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

    static ArrayList<Integer> list = new ArrayList<>();

    public static void printPaths(Node root) {
        if (root == null) {
            return;
        }

        list.add(root.data);

        if (root.left == null && root.right == null) {
            System.out.print(list + " ");
        }

        printPaths(root.left);
        printPaths(root.right);

        list.remove(list.size() - 1);
    }

    public static void main(String[] args) {
        int values[] = { 8, 5, 3, 1, 4, 6, 10, 11, 14 };

        Node root = null;

        for (int i = 0; i < values.length; i++) {
            root = insert(root, values[i]);
        }

        printPaths(root);
    }
}
