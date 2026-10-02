package lw03.prelab;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.Map;

public class Main {
    
    public static void main(String[] args) {
        System.out.println("===== Problem 1 =====");
        Scanner e = new Scanner(Main.class.getResourceAsStream("playlist.txt"));
        List<String> playlist = new LinkedList<>();
        while (e.hasNext()) {
            String task = e.next();
            if (task.equals("ADD")) {
                playlist.add(e.nextLine());
            } else if(task.equals("REMOVE")) {
                String nama = e.nextLine();
                playlist.remove(playlist.indexOf(nama));
            } else if (task.equals("INSERT")) {
                int index = e.nextInt();
                String nama = e.nextLine();
                playlist.add(index, nama);
            }
        }
        e.close();
        System.out.println("Total songs: " + playlist.size());
        for(int i = 1;i<=playlist.size();i++) {
            System.out.println(i + ":" + playlist.get(i-1));
        }

        System.out.println();

        System.out.println("===== Problem 2 =====");
        Scanner ek = new Scanner(Main.class.getResourceAsStream("participants.txt"));
        Set<String> participants = new LinkedHashSet<>();
        int dupes = 0;
        while(ek.hasNext()) {
            String nama = ek.next();
            if(!participants.contains(nama)) {
                participants.add(nama);
            } else {
                dupes += 1;
            }
        }
        ek.close();

        System.out.println("Unique participants: " + participants.size());
        int count = 1;
        for(String participant : participants) {
            System.out.println(count++ + ": " + participant);
        }
        System.out.println("Duplicate registrations: " + dupes);

        System.out.println();
        
        System.out.println("===== Problem 3 =====");
        Scanner eka = new Scanner(Main.class.getResourceAsStream("inventory.txt"));
        Map<String, Integer> inventory = new LinkedHashMap<>();
        int failCount = 0;
        while(eka.hasNext()) {
            String type = eka.next();
            String product = eka.next();
            int quality = eka.nextInt();

            if(type.equals("ADD")) {
                if(!inventory.containsKey(product)) {
                    inventory.put(product, quality);
                    continue;
                } else {
                    inventory.put(product, inventory.get(product) + quality);
                    continue;
                }
            } else if(type.equals("SELL")) {
                if(!inventory.containsKey(product) || inventory.get(product)<quality) {
                    ++failCount;
                    continue;
                } else {
                    inventory.put(product, inventory.get(product) - quality);
                    continue;
                }
            }
        }
        eka.close();
        for(String item : inventory.keySet()) {
            System.out.println(item + ": " + inventory.get(item));
        }
        System.out.println("Failed sales: " + failCount);
    }
}
