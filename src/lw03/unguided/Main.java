package lw03.unguided;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner ek = new Scanner(Main.class.getResourceAsStream("enrollment.txt"));

        Map<String, Integer> courses = new LinkedHashMap<>();
        int fail = 0;

        System.out.println("===== Enrollment Checks =====");
        while (ek.hasNext()) {
            String operation = ek.next();
            String courseName = ek.next();
            if (operation.equals("REGISTER")) {
                int attendee = ek.nextInt();
                if (attendee<=0) {
                    fail++;
                    continue;
                }
                if(!courses.containsKey(courseName)) {
                    courses.put(courseName, attendee);
                } else if (courses.containsKey(courseName)) {
                    courses.put(courseName, courses.get(courseName) + attendee);
                }
            } else if (operation.equals("WITHDRAW")) {
                int dropee = ek.nextInt();
                if (dropee<=0) {
                    fail++;
                    continue;
                }
                if(courses.containsKey(courseName) && courses.get(courseName)>=dropee) {
                    courses.put(courseName, courses.get(courseName) - dropee);
                }  else {
                    fail++;
                }
            } else if (operation.equals("CHECK")) {
                if(courses.containsKey(courseName)) {
                    System.out.println(courseName + ": " + courses.get(courseName) + " students");
                } else if (!courses.containsKey(courseName)) {
                    System.out.println(courseName + ": Not found");
                } else {
                    fail++;
                }
            }
        }
        ek.close();

        System.out.println("\n===== Final Enrollment =====");
        for(String course : courses.keySet()) {
            System.out.println(course + ": " + courses.get(course) + " students");
        }

        System.out.println("\nRejected operations: " + fail);
    }
}
