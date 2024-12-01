package asm2;

import java.util.Scanner;

public class StudentQueue {
    private Node front, rear;

    public StudentQueue() {
        this.front = this.rear = null;
    }

    // Add a new student
    public void enqueue(Student student) {
        Node newNode = new Node(student);
        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
    }

    // Remove a student from the queue
    public Student dequeue() {
        if (front == null) {
            System.out.println("The queue is empty.");
            return null;
        }
        Student removedStudent = front.student;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        return removedStudent;
    }

    // Display all students in the queue
    public void display() {
        if (front == null) {
            System.out.println("The queue is empty.");
            return;
        }
        Node temp = front;
        System.out.println("--- Student Queue ---");
        while (temp != null) {
            temp.student.printInfo();
            temp = temp.next;
        }
    }

    // Edit a student's information
    public void editStudent(int id, Scanner scanner) {
        Node temp = front;
        while (temp != null) {
            if (temp.student.getId() == id) {
                System.out.print("Enter new name: ");
                String newName = scanner.nextLine();
                System.out.print("Enter new score: ");
                double newScore = Double.parseDouble(scanner.nextLine());
                temp.student.setName(newName);
                temp.student.setScore(newScore);
                System.out.println("Student information updated.");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Student not found.");
    }

    // Delete a student by ID
    public void deleteStudent(int id) {
        Node temp = front, prev = null;
        while (temp != null && temp.student.getId() != id) {
            prev = temp;
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Student not found.");
            return;
        }
        if (temp == front) {
            front = front.next;
        } else {
            prev.next = temp.next;
        }
        if (temp == rear) {
            rear = prev;
        }
        System.out.println("Student deleted.");
    }

    // Search a student by ID
    public void searchStudent(int id) {
        Node temp = front;
        while (temp != null) {
            if (temp.student.getId() == id) {
                temp.student.printInfo();
                return;
            }
            temp = temp.next;
        }
        System.out.println("Student not found.");
    }

    // Bubble Sort students in the queue based on score
    public void bubbleSort() {
        if (front == null) {
            System.out.println("The queue is empty.");
            return;
        }
        boolean swapped;
        do {
            swapped = false;
            Node temp = front;
            while (temp != null && temp.next != null) {
                if (temp.student.getScore() < temp.next.student.getScore()) {
                    // Swap the students
                    Student tempStudent = temp.student;
                    temp.student = temp.next.student;
                    temp.next.student = tempStudent;
                    swapped = true;
                }
                temp = temp.next;
            }
        } while (swapped);
        System.out.println("Queue sorted using Bubble Sort.");
    }

    // Selection Sort students in the queue based on score
    public void selectionSort() {
        if (front == null) {
            System.out.println("The queue is empty.");
            return;
        }
        Node temp1 = front;
        while (temp1 != null) {
            Node temp2 = temp1.next;
            Node minNode = temp1;
            while (temp2 != null) {
                if (temp2.student.getScore() < minNode.student.getScore()) {
                    minNode = temp2;
                }
                temp2 = temp2.next;
            }
            if (minNode != temp1) {
                // Swap the students
                Student tempStudent = temp1.student;
                temp1.student = minNode.student;
                minNode.student = tempStudent;
            }
            temp1 = temp1.next;
        }
        System.out.println("Queue sorted using Selection Sort.");
    }
    
}
