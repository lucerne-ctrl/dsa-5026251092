package lw01.unguided;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner ek = new Scanner(Main.class.getResourceAsStream("rentals.txt"));

        int count = ek.nextInt();
        Rental[] rental = new Rental[count];
        int[] units = new int[count];

        for(int i = 0; i < count; i++) {
            String type = ek.next();
            String id = ek.next();
            int days = ek.nextInt();
            units[i] = ek.nextInt();

            if(type.equals("LAPTOP")) {
                rental[i] = new LaptopRental(id, days);
            } else {
                rental[i] = new ProjectorRental(id, days);
            }
        }
        
        for (int i = 0;i < count;i++) {
            System.out.println(rental[i].summary(units[i]));
        }
        ek.close();
    }
}
