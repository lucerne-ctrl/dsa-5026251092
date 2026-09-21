package lw01.prelab;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner ek = new Scanner(Main.class.getResourceAsStream("jobs.txt"));
        List<PrintJob> jobs = new ArrayList<>();

        while (ek.hasNext()) {
            String type = ek.next();
            String id = ek.next();
            int pages = ek.nextInt();

            if (type.equals("MONO")) {
                jobs.add(new MonoPrint(id, pages));
            } else if (type.equals("COLOUR")) {
                jobs.add(new ColourPrint(id, pages));
            }
        }

        for (PrintJob job : jobs) {
            System.out.println(job.summary());
        }
        ek.close();
    }
}
