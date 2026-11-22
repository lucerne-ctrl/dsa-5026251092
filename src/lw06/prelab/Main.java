package lw06.prelab;
import java.util.Scanner;

public class Main {

    public static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        }

        if (root.data > data) {
            root.left = insert(root.left, data);
        } else if (root.data < data) {
            root.right = insert(root.right, data);
        }

        return root;
    }

    public static boolean search(Node root, int target) {
        if (root == null) {
            return false;
        }

        if (root.data == target) {
            return true;
        } else if (root.data > target) {
            return search(root.left, target);
        } else {
            return search(root.right, target);
        }
    }

    public static void preorder(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    public static void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

    public static void postorder(Node root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data + " ");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(Main.class.getResourceAsStream("treenumbers.txt"));
        String[] num = sc.nextLine().split("\\s+");
        int[] score = new int[num.length];
        for (int i = 0; i < num.length; i++) {
            score[i] = Integer.parseInt(num[i]);
        }

        Node root = null;
        for (int i : score) {
            root = insert(root, i);
        }

        System.out.print("Preorder: ");
        preorder(root);
        System.out.println();

        System.out.print("Inorder: ");
        inorder(root);
        System.out.println();

        System.out.print("Postorder: ");
        postorder(root);
        System.out.println();

        int target = sc.nextInt();
        System.out.println("Search " + target + " : " + search(root, target));
        sc.close();
    }
}