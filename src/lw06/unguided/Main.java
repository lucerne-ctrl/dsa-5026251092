package lw06.unguided;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner read = new Scanner(Main.class.getResourceAsStream("treenumbers.txt"));
        String[] num = read.nextLine().split("\\s+");
        int[] score = new int[num.length];
        for (int i = 0; i < num.length; i++) {
            score[i] = Integer.parseInt(num[i]);
        }

        BinarySearchTree a = new BinarySearchTree();

        for (int i : score) {
            a.insert(i);
        }
        System.out.print("Preorder : ");
        a.preOrder();

        System.out.print("Inorder : ");
        a.inOrder();

        System.out.print("Postorder : ");
        a.postOrder();

        int target = read.nextInt();
        System.out.println("Search " + target + " : " + a.search(target));

        int min = a.findMin();
        System.out.println("Minimun : " + min);

        int max = a.findMax();
        System.out.println("Maximum : " + max);
        read.close();
    }
}
