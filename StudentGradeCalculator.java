import java.util.Scanner;

public class StudentGradeCalculator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("====================================");
        System.out.println("      STUDENT GRADE CALCULATOR      ");
        System.out.println("====================================");

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Number of Subjects: ");
        int subjects = sc.nextInt();

        int totalMarks = 0;

        for (int i = 1; i <= subjects; i++) {

            int mark;

            while (true) {
                System.out.print("Enter marks for Subject " + i + " (0-100): ");
                mark = sc.nextInt();

                if (mark >= 0 && mark <= 100) {
                    break;
                } else {
                    System.out.println("Invalid Marks! Please enter between 0 and 100.");
                }
            }

            totalMarks += mark;
        }

        double average = (double) totalMarks / subjects;

        String grade;
        String result;

        if (average >= 90) {
            grade = "A+";
        } else if (average >= 80) {
            grade = "A";
        } else if (average >= 70) {
            grade = "B";
        } else if (average >= 60) {
            grade = "C";
        } else if (average >= 50) {
            grade = "D";
        } else {
            grade = "F";
        }

        if (average >= 50) {
            result = "PASS";
        } else {
            result = "FAIL";
        }

        System.out.println("\n====================================");
        System.out.println("         STUDENT REPORT CARD");
        System.out.println("====================================");
        System.out.println("Student Name      : " + name);
        System.out.println("Number of Subjects: " + subjects);
        System.out.println("Total Marks       : " + totalMarks);
        System.out.printf("Average Percentage: %.2f%%\n", average);
        System.out.println("Grade             : " + grade);
        System.out.println("Result            : " + result);
        System.out.println("====================================");

        sc.close();
    }
}
