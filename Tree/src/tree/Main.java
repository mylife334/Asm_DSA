package tree;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentBST tree = new StudentBST();

        while (true) {
            try {
                System.out.println("1. Add Student\n2. Edit Student\n3. Delete Student\n4. Search Student\n5. Display Students Sorted by ID\n6. Display Students Sorted by Marks\n7. Exit");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine();  // Consume newline

                switch (choice) {
                    case 1:
                        System.out.print("Enter Student ID: ");
                        String id = scanner.nextLine();
                        System.out.print("Enter Student Name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter Student Marks: ");
                        double marks = scanner.nextDouble();
                        tree.addStudent(id, name, marks);
                        break;

                    case 2:
                        System.out.print("Enter Student ID to Edit: ");
                        id = scanner.nextLine();
                        System.out.print("Enter New Name: ");
                        name = scanner.nextLine();
                        System.out.print("Enter New Marks: ");
                        marks = scanner.nextDouble();
                        tree.editStudent(id, name, marks);
                        break;

                    case 3:
                        System.out.print("Enter Student ID to Delete: ");
                        id = scanner.nextLine();
                        tree.deleteStudent(id);
                        break;

                    case 4:
                        System.out.print("Enter Student ID to Search: ");
                        id = scanner.nextLine();
                        Student student = tree.searchStudent(id);
                        if (student != null) {
                            student.display();
                        } else {
                            System.out.println("Student not found.");
                        }
                        break;

                    case 5:
                        tree.displaySortedStudents();
                        break;

                    case 6:
                        tree.sortByMarks();
                        break;

                    case 7:
                        System.out.println("Exiting...");
                        scanner.close();
                        return;

                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
                scanner.nextLine();  // Consume any leftover newline characters
            }
        }
    }
}
