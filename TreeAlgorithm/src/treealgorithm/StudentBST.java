import java.util.Scanner;

public class StudentBST {

    // Lớp Student lưu thông tin sinh viên
    static class Student {
        private int id;
        private String name;
        private double grade;

        public Student(int id, String name, double grade) {
            this.id = id;
            this.name = name;
            this.grade = grade;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public double getGrade() {
            return grade;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setGrade(double grade) {
            this.grade = grade;
        }

        public void printInfo() {
            System.out.println("ID: " + id + ", Name: " + name + ", Grade: " + grade);
        }
    }

    // Lớp Node lưu trữ thông tin của từng sinh viên và liên kết cây nhị phân
    static class Node {
        Student student;
        Node left, right;

        public Node(Student student) {
            this.student = student;
            this.left = this.right = null;
        }
    }

    // Lớp BinarySearchTree xử lý các phương thức như thêm sinh viên, duyệt cây, tìm kiếm
    static class BinarySearchTree {
        private Node root;

        public BinarySearchTree() {
            root = null;
        }

        // Thêm một sinh viên vào cây
        public void insert(Student student) {
            root = insertRec(root, student);
        }

        private Node insertRec(Node root, Student student) {
            if (root == null) {
                root = new Node(student);
                return root;
            }
            if (student.getId() < root.student.getId()) {
                root.left = insertRec(root.left, student);
            } else if (student.getId() > root.student.getId()) {
                root.right = insertRec(root.right, student);
            }
            return root;
        }

        // Duyệt cây nhị phân theo thứ tự tăng dần (In-Order Traversal)
        public void inOrderTraversal() {
            inOrderRec(root);
        }

        private void inOrderRec(Node root) {
            if (root != null) {
                inOrderRec(root.left);
                root.student.printInfo();
                inOrderRec(root.right);
            }
        }

        // Tìm kiếm sinh viên theo ID
        public Student search(int id) {
            return searchRec(root, id);
        }

        private Student searchRec(Node root, int id) {
            if (root == null || root.student.getId() == id) {
                return root != null ? root.student : null;
            }
            if (id < root.student.getId()) {
                return searchRec(root.left, id);
            }
            return searchRec(root.right, id);
        }
    }

    // Lớp Node cho Queue
    static class NodeQueue {
        Student student;
        NodeQueue next;

        public NodeQueue(Student student) {
            this.student = student;
            this.next = null;
        }
    }

    // Lớp Queue để chứa sinh viên
    static class StudentQueue {
        private NodeQueue front, rear;

        public StudentQueue() {
            this.front = this.rear = null;
        }

        // Thêm sinh viên vào hàng đợi
        public void enqueue(Student student) {
            NodeQueue newNode = new NodeQueue(student);
            if (rear == null) {
                front = rear = newNode;
            } else {
                rear.next = newNode;
                rear = newNode;
            }
        }

        // Hiển thị danh sách sinh viên trong hàng đợi
        public void display() {
            if (front == null) {
                System.out.println("The queue is empty.");
                return;
            }
            NodeQueue temp = front;
            while (temp != null) {
                temp.student.printInfo();
                temp = temp.next;
            }
        }

        // Bubble Sort sinh viên trong hàng đợi
        public void bubbleSort() {
            if (front == null) {
                System.out.println("The queue is empty.");
                return;
            }
            boolean swapped;
            do {
                swapped = false;
                NodeQueue temp = front;
                while (temp != null && temp.next != null) {
                    if (temp.student.getGrade() < temp.next.student.getGrade()) {
                        // Swap sinh viên
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

        // Selection Sort sinh viên trong hàng đợi
        public void selectionSort() {
            if (front == null) {
                System.out.println("The queue is empty.");
                return;
            }
            NodeQueue temp1 = front;
            while (temp1 != null) {
                NodeQueue temp2 = temp1.next;
                NodeQueue minNode = temp1;
                while (temp2 != null) {
                    if (temp2.student.getGrade() < minNode.student.getGrade()) {
                        minNode = temp2;
                    }
                    temp2 = temp2.next;
                }
                if (minNode != temp1) {
                    // Swap sinh viên
                    Student tempStudent = temp1.student;
                    temp1.student = minNode.student;
                    minNode.student = tempStudent;
                }
                temp1 = temp1.next;
            }
            System.out.println("Queue sorted using Selection Sort.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Tạo cây nhị phân tìm kiếm
        BinarySearchTree bst = new BinarySearchTree();

        // Thêm sinh viên vào cây
        bst.insert(new Student(1, "Alice", 92.0));
        bst.insert(new Student(2, "Bob", 78.0));
        bst.insert(new Student(3, "John", 85.5));
        bst.insert(new Student(4, "Eve", 91.5));
        bst.insert(new Student(5, "Charlie", 88.0));
        bst.insert(new Student(6, "David", 95.0));
        bst.insert(new Student(7, "Frank", 77.5));
        bst.insert(new Student(8, "Grace", 90.0));
        bst.insert(new Student(9, "Helen", 89.5));
        bst.insert(new Student(10, "Ivy", 82.0));

        // Hiển thị tất cả sinh viên theo thứ tự In-Order Traversal
        System.out.println("In-Order Traversal of BST:");
        bst.inOrderTraversal();

        // Tạo hàng đợi sinh viên
        StudentQueue queue = new StudentQueue();

        // Thêm các sinh viên vào hàng đợi
        queue.enqueue(new Student(1, "Alice", 92.0));
        queue.enqueue(new Student(2, "Bob", 78.0));
        queue.enqueue(new Student(3, "John", 85.5));
        queue.enqueue(new Student(4, "Eve", 91.5));
        queue.enqueue(new Student(5, "Charlie", 88.0));
        queue.enqueue(new Student(6, "David", 95.0));
        queue.enqueue(new Student(7, "Frank", 77.5));
        queue.enqueue(new Student(8, "Grace", 90.0));
        queue.enqueue(new Student(9, "Helen", 89.5));
        queue.enqueue(new Student(10, "Ivy", 82.0));

        // Hiển thị danh sách sinh viên trước khi sắp xếp
        System.out.println("\nBefore sorting:");
        queue.display();

        // Sắp xếp sinh viên trong hàng đợi với Bubble Sort
        queue.bubbleSort();
        System.out.println("\nAfter Bubble Sort:");
        queue.display();

        // Sắp xếp sinh viên trong hàng đợi với Selection Sort
        queue.selectionSort();
        System.out.println("\nAfter Selection Sort:");
        queue.display();

        // Tìm kiếm sinh viên có ID = 6
        System.out.println("\nSearching for student with ID 6:");
        Student student = bst.search(6);
        if (student != null) {
            student.printInfo();
        } else {
            System.out.println("Student not found.");
        }
    }
}
