/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tree;

class Student {
    String id;
    String name;
    double marks;
    Student left, right;

    public Student(String id, String name, double marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
        this.left = null;
        this.right = null;
    }

    // Method to determine the student's ranking based on marks
    public String getRanking() {
        if (marks < 5.0) return "Fail";
        else if (marks < 6.5) return "Medium";
        else if (marks < 7.5) return "Good";
        else if (marks < 9.0) return "Very Good";
        else return "Excellent";
    }

    // Method to display student information
    public void display() {
        System.out.printf("ID: %s | Name: %s | Marks: %.2f | Rank: %s\n", id, name, marks, getRanking());
    }
}

class StudentBST {
    Student root;

    public StudentBST() {
        root = null;
    }

    // Add a new student to the tree
    public void addStudent(String id, String name, double marks) {
        root = addRecursive(root, new Student(id, name, marks));
    }

    private Student addRecursive(Student current, Student newStudent) {
        if (current == null) {
            return newStudent;
        }
        if (newStudent.id.compareTo(current.id) < 0) {
            current.left = addRecursive(current.left, newStudent);
        } else if (newStudent.id.compareTo(current.id) > 0) {
            current.right = addRecursive(current.right, newStudent);
        }
        return current;
    }

    // Edit a student's information by ID
    public void editStudent(String id, String newName, double newMarks) {
        Student student = searchRecursive(root, id);
        if (student != null) {
            student.name = newName;
            student.marks = newMarks;
            System.out.println("Student details updated.");
        } else {
            System.out.println("Student not found.");
        }
    }

    // Delete a student by ID
    public void deleteStudent(String id) {
        root = deleteRecursive(root, id);
    }

    private Student deleteRecursive(Student current, String id) {
        if (current == null) {
            return null;
        }
        if (id.equals(current.id)) {
            if (current.left == null && current.right == null) {
                return null;
            }
            if (current.left == null) {
                return current.right;
            }
            if (current.right == null) {
                return current.left;
            }
            Student smallest = findSmallest(current.right);
            current.id = smallest.id;
            current.name = smallest.name;
            current.marks = smallest.marks;
            current.right = deleteRecursive(current.right, smallest.id);
            return current;
        }
        if (id.compareTo(current.id) < 0) {
            current.left = deleteRecursive(current.left, id);
        } else {
            current.right = deleteRecursive(current.right, id);
        }
        return current;
    }

    private Student findSmallest(Student root) {
        return root.left == null ? root : findSmallest(root.left);
    }

    // Search for a student by ID
    public Student searchStudent(String id) {
        return searchRecursive(root, id);
    }

    private Student searchRecursive(Student current, String id) {
        if (current == null || current.id.equals(id)) {
            return current;
        }
        return id.compareTo(current.id) < 0 ? searchRecursive(current.left, id) : searchRecursive(current.right, id);
    }

    // Display all students in sorted order by their IDs
    public void displaySortedStudents() {
        System.out.println("Displaying students in sorted order:");
        inOrderTraversal(root);
    }

    private void inOrderTraversal(Student current) {
        if (current != null) {
            inOrderTraversal(current.left);
            current.display();
            inOrderTraversal(current.right);
        }
    }

    // Sort and display students by their marks in ascending order
    public void sortByMarks() {
        System.out.println("Displaying students sorted by marks:");
        sortByMarksRecursive(root);
    }

    private void sortByMarksRecursive(Student current) {
        if (current != null) {
            sortByMarksRecursive(current.left);
            current.display();
            sortByMarksRecursive(current.right);
        }
    }
}