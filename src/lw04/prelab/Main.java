package lw04.prelab;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner ek = new Scanner(Main.class.getResourceAsStream("branches.txt"));

        int branchAmount = ek.nextInt();
        int[] stabilityValue = new int[branchAmount];
        for(int i = 0;i<branchAmount;i++) {
            stabilityValue[i] = ek.nextInt();
        }
        int targetAmount = ek.nextInt();
        int[] targets = new int[targetAmount];
        for(int i = 0;i<targetAmount;i++) {
            targets[i] = ek.nextInt();
        }
        ek.close();

        for(int i = 1;i<=3;i++) {
            int key = stabilityValue[i];
            int j = i-1;
            while(j >= 0 && stabilityValue[j] < key) {
                stabilityValue[j+1] = stabilityValue[j];
                j--;
            }
            stabilityValue[j+1] = key; 
        }
        for(int num : stabilityValue) {
            System.out.print(num + " ");
        }

        System.out.println();
        for(int num : targets) {
            boolean is = false;
            for(int i = 0;i<branchAmount;i++) {
                if(stabilityValue[i]==num) {
                    System.out.println(num + ": FOUND at index " + i);
                    is = true;
                    break;
                }
            }
            if(!is) {
                System.out.println(num + ": NOT FOUND");
            }
        }
    }
}
