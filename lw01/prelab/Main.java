import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner ek = new Scanner(new File("/Users/ekasetiawan/Desktop/Praktikum ASD/dsa-5026251092/lw01/prelab/jobs.txt"))) {
            PrintJob[] job = new PrintJob[100];
            int count = 0;

            while (ek.hasNext()) {
                String type = ek.next();
                String id = ek.next();
                int pages = ek.nextInt();

                if(type.equals("MONO")) {
                    job[count++] = new MonoPrint(id, pages);
                } else if (type.equals("COLOUR")) {
                    job[count++] = new ColourPrint(id, pages);
                }
            }

            for (int i = 0; i < count; i++) {
                System.out.println(job[i].summary());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
