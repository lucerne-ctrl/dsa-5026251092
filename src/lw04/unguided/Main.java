package lw04.unguided;

import java.util.Scanner;

public class Main {
    static void rakaSort(int[] a, int pass) {
        int n = a.length;
        for(int i = 0; i<pass; i++) {
            int min = i;
            for(int j = i+i; j<n; j++) {
                if(a[j] < a[min]) {
                    min = j;
                }
            }
            int temp = a[min];
            a[min] = a[i];
            a[i] = temp;
        }
    }

    static int rakaSearch(int[]a, int target) {
        for(int i = 0; i<a.length; i++) {
            if(a[i]==target) return i;
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner ek = new Scanner(Main.class.getResourceAsStream("cards.txt"));
        int n = ek.nextInt();
        int[] cardNumber = new int[n];
        for(int i = 0; i<n; i++) {
            cardNumber[i] = ek.nextInt();
        }

        int m = ek.nextInt();
        int[] targets = new int[m];
        for(int i = 0; i<m; i++) {
            targets[i] = ek.nextInt();
        }

        ek.close();

        rakaSort(cardNumber, 2);
        for (int i : cardNumber) {
            System.out.print(i + " ");
        }

        System.out.println();
        for (int i : targets) {
            int idx = rakaSearch(cardNumber, i);
            if(idx==-1) {
                System.out.println(i + ": NOT FOUND");
            } else {
                System.out.println(i + ": FOUND at index " + idx);
            }
        }
    }
}
