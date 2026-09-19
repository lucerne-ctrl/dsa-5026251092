import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner ek = new Scanner(new File("/Users/ekasetiawan/Desktop/Praktikum ASD/dsa-5026251092/lw01/prelab/jobs.txt"))) {
            ArrayList<PrintJob> job = new ArrayList<>();

            while (ek.hasNext()) {
                String type = ek.next();
                String id = ek.next();
                int pages = ek.nextInt();

                if(type.equals("MONO")) {
                    job.add(new MonoPrint(id, pages));
                } else if (type.equals("COLOUR")) {
                    job.add(new ColourPrint(id, pages));
                }
            }

            for (PrintJob job2 : job) {
                System.out.println(job2.summary());
            }

            ek.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
