package com.timrabl;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        GradeProcessor processor = new GradeProcessor();

        while (true) {
            System.out.print("Enter a grade or mode: ");
            String input = scanner.nextLine();
            String type;
            int grade = 0;

            try {
                grade = Integer.parseInt(input);
                type = "int";
            } catch (NumberFormatException ex) {
                type = "char";
            }

            if ( type.equals("char") ) {
                if ( !( processor.changeGradeMode(input) ) ) {
                    System.out.println("Invalid mode: " + input);
                    continue;
                }

                String mode = processor.getGradeMode();

                if ( mode.equals("exit") ) {
                    System.out.println("# =========================================================== #");

                    float avgGrade = processor.getGradeListAverage();
                    System.out.printf("Grade average is: \t\t\t\t\t\t\t\t%.2f\n", avgGrade);

                    ArrayList<Integer> gradesToLower = processor.getMissingGradesToLower();
                    System.out.printf("Required grades lower (%s): \t\t\t\t\t%s\n", Math.floor(avgGrade), gradesToLower);

                    System.out.printf("Final grade will be: \t\t\t\t\t\t\t%.2f\n", (float)Math.round(avgGrade));

                    System.out.println("# =========================================================== #");
                    System.out.println("Exiting, bye bye !");
                    System.exit(0);
                }

                System.out.println("Switching to " + mode + " mode !");
            }

            if ( type.equals("int") ) {
                try {
                    processor.addGrade(grade);
                } catch (InvalidGrade ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
    }
}
