/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asm2;

/**
 *
 * @author PC
 */
import java.util.Scanner;

public class Main {
    private static StudentQueue queue = new StudentQueue();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            try {
                System.out.println("\nOptions:");
                System.out.println("1. Add Student");
                System.out.println("2. Display Students");
                System.out.println("3. Edit Student");
                System.out.println("4. Remove Student");
                System.out.println("5. Search Student");
                System.out.println("6. Exit");
                System.out.print("Choose an option: ");
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        addStudent();
                        break;
                    case 2:
                        queue.display();
                        break;
                    case 3:
                        editStudent();
                        break;
                    case 4:
                        removeStudent();
                        break;
                    case 5:
                        searchStudent();
                        break;
                    case 6:
                        running = false;
                        System.out.println("Exiting program.");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
            } catch (Exception e) {
                System.out.println("An unexpected error occurred: " + e.getMessage());
            }
        }
    }

    private static void addStudent() {
        System.out.print("Enter ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Score: ");
        double score = Double.parseDouble(scanner.nextLine());

        Student student = new Student(id, name, score);
        queue.enqueue(student);
        System.out.println("Student add Success.");
    }

    private static void editStudent() {
        System.out.print("Enter the ID of the student to edit: ");
        int id = Integer.parseInt(scanner.nextLine());
        queue.editStudent(id, scanner);
    }

    private static void removeStudent() {
        System.out.print("Enter the ID of the student to remove: ");
        int id = Integer.parseInt(scanner.nextLine());
        queue.deleteStudent(id);
    }

    private static void searchStudent() {
        System.out.print("Enter the ID of the student to search: ");
        int id = Integer.parseInt(scanner.nextLine());
        queue.searchStudent(id);
    }
}

