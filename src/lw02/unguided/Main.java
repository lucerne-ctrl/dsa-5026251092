package lw02.unguided;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner ek = new Scanner(Main.class.getResourceAsStream("borrowing.txt"));

        LinkedList<String[]> requests = new LinkedList<>();
        LinkedList<String[]> members = new LinkedList<>();
        
        while(ek.hasNext()) {
            String[] request = new String[2];
            request[0] = ek.next();
            request[1] = ek.next();
            
            if(members.isEmpty()) {
                members.add(new String[]{request[0], "0"});
            } else {
                boolean checkAda = false;
                for(String[] tes : members) {
                    if(tes[0].equals(request[0])) {
                        checkAda = true;
                        break;
                    }
                }
                if(!checkAda) members.add(new String[]{request[0], "0"});
            }

            requests.add(request);
        }
        
        LinkedList<String[]> bookStock = new LinkedList<>();
        bookStock.push(new String[] {"Statistika", "2"});
        bookStock.push(new String[] {"Fisika", "1"});
        bookStock.push(new String[] {"Kalkulus", "2"});
        
        Queue<String[]> qrequests = requests;

        System.out.println("=== Successfully Processed Requests ===");

        Stack<String[]> failedRequest = new Stack<>();

        while(!qrequests.isEmpty()) {
            String[] request = qrequests.poll();
            String NAME = request[0];
            String BOOK_TITLE = request[1];
            
            for(String[] member : members) {  
                String namaMember = member[0];
                int MAX_BORROW = Integer.valueOf(member[1]);
                        if(namaMember.equals(NAME)) {
                            for(String[] book : bookStock) {
                                String namaBuku = book[0];
                                int stokBuku = Integer.valueOf(book[1]);
                                if (namaBuku.equals(BOOK_TITLE)) {
                                    if (stokBuku != 0 && MAX_BORROW < 2) {
                                        book[1] = String.valueOf(stokBuku - 1);
                                        member[1] = String.valueOf(MAX_BORROW + 1);
                                        System.out.println(namaMember + " " + namaBuku);
                                    } else {
                                        failedRequest.push(request);
                                    }
                                }
                            }
                        }
                    }            
            
            
        }

        System.out.println();
        System.out.println("=== Remaining Book Stock ===");
        for(String[] book : bookStock) {
            System.out.println(book[0] + ": " + book[1]);
        }

        System.out.println();
        System.out.println("=== Failed Requests ===");
        while(!failedRequest.isEmpty()) {
            String[] fail = failedRequest.pop();
            System.out.println(fail[0] + " " + fail[1]);
        }

        ek.close();
    }
}
