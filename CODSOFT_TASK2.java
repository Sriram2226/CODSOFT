import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int numStudents = scanner.nextInt();

        // Create an array to store student objects
        Student[] students = new Student[numStudents];

        // Input details for each student
        for (int i = 0; i < numStudents; i++) {
            System.out.println("Enter details for student " + (i + 1) + ":");
            System.out.print("Name: ");
            String name = scanner.next();
            System.out.print("Enter the number of subjects: ");
            int numSubjects = scanner.nextInt();

            // Create an array to store subject marks for each student
            int[] marks = new int[numSubjects];

            // Input marks for each subject
            for (int j = 0; j < numSubjects; j++) {
                System.out.print("Enter marks obtained in subject " + (j + 1) + " for " + name + ": ");
                marks[j] = scanner.nextInt();
            }

            // Create a student object and store it in the array
            students[i] = new Student(name, marks);
        }

        // Display details for each student
        for (int i = 0; i < numStudents; i++) {
            System.out.println("\nDetails for student " + (i + 1) + ":");
            students[i].displayDetails();
            students[i].calculateTotalMarks();
            students[i].calculateAveragePercentage();
            students[i].calculateGrade();
            students[i].displayResult();
            students[i].displaySubjectMarks();
        }

        scanner.close();
    }
}

class Student {
    private String name;
    private int[] subjectMarks;
    private int totalMarks;
    private double averagePercentage;
    private char grade;

    // Constructor to initialize name and subject marks
    public Student(String name, int[] subjectMarks) {
        this.name = name;
        this.subjectMarks = subjectMarks;
    }

    // Method to calculate total marks
    public void calculateTotalMarks() {
        totalMarks = 0;
        for (int mark : subjectMarks) {
            totalMarks += mark;
        }
    }

    // Method to calculate average percentage
    public void calculateAveragePercentage() {
        averagePercentage = (double) totalMarks / subjectMarks.length;
    }

    // Method to calculate grade
    public void calculateGrade() {
        if (averagePercentage >= 90) {
            grade = 'A';
        } else if (averagePercentage >= 80) {
            grade = 'B';
        } else if (averagePercentage >= 70) {
            grade = 'C';
        } else if (averagePercentage >= 60) {
            grade = 'D';
        } else {
            grade = 'F';
        }
    }

    // Method to display student details
    public void displayDetails() {
        System.out.println("Name: " + name);
    }

    // Method to display student result
    public void displayResult() {
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + averagePercentage + "%");
        System.out.println("Grade: " + grade);
    }

    // Method to display subject marks
    public void displaySubjectMarks() {
        System.out.print("Subject Marks: ");
        for (int mark : subjectMarks) {
            System.out.print(mark + " ");
        }
        System.out.println();
    }
}
