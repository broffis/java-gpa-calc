package com.gpaCalc;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

class Calculator {
    public static void main(String[] args) {
        // Total points / total credits
        // points for class = grade value * credits
        // A=4, B-3, C=2, D=1
        try(Scanner scanner = new Scanner(System.in)) {
            Integer totalPoints = 0;
            Integer totalCredits = 0;

            boolean allGradesEntered = false;
            do {
                Integer credits = 0;

                // Get credits
                boolean validCredits = false;
                do {
                    System.out.println("Enter number of credits: ");
                    String creditString = scanner.nextLine();
                    try {
                        credits  =  Integer.parseInt(creditString);
                        validCredits = true;

                    } catch (NumberFormatException fe) {
                        System.out.println("Please enter a valid integer");
                    }

                } while(!validCredits);

                System.out.println("credits: " + credits);

                // Get Grade
                boolean validGrade = false;
                Integer gradeValue = 0;
                String grade = "";
                do {
                    System.out.println("Enter grade:");
                    grade = scanner.nextLine().toLowerCase();

                    if (grade.charAt(0) >= 97 && grade.charAt(0) <= 102) {
                        switch(grade) {
                            case "a" -> gradeValue = 4;
                            case "b" -> gradeValue = 3;
                            case "c" -> gradeValue = 2;
                            case "d" -> gradeValue = 1;
                            case "e" -> gradeValue = 0;
                            case "f" -> gradeValue = 0;
                        }
                        validGrade = true;
                    } else {
                        System.out.println("Incorrect grade entered. Please select A, B, C, D, or E/F");
                    }
                } while (!validGrade);

                Integer points = gradeValue * credits;


                totalCredits += credits;
                totalPoints += points;


                boolean allFinishedResponse = false;
                do {
                    System.out.println("Are you finished? (Y/N) ");
                    String isDone = scanner.nextLine().toLowerCase();
                    if (isDone.charAt(0) == 121) {
                        allGradesEntered = true;
                        allFinishedResponse = true;
                    } else if (isDone.charAt(0) == 110) {
                        allFinishedResponse = true;
                    } else {
                        System.out.println("Please only enter Y or N");
                    }
                } while (!allFinishedResponse);


            } while (!allGradesEntered);


            BigDecimal gpa = new BigDecimal(totalPoints).divide(new BigDecimal(totalCredits), 2, RoundingMode.HALF_UP );
            System.out.println("GPA: " + gpa);
        }
    }
}