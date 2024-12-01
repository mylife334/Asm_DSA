/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asm2;

/**
 *
 * @author PC
 */
public class Student {
    private int id;
    private String name;
    private double score;
    private String category; // Category (Fail, Medium, Very Good)

    public Student(int id, String name, double score) {
        this.id = id;
        this.name = name;
        this.score = score;
        setCategory(); // Set category based on score
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
        setCategory(); // Update category when score changes
    }

    public String getCategory() {
        return category;
    }

    private void setCategory() {
        if (score >= 8.0) {
            this.category = "Very Good";
        } else if (score >= 5.0) {
            this.category = "Medium";
        } else {
            this.category = "Fail";
        }
    }

    public void printInfo() {
        System.out.printf("ID: %d | Name: %s | Marks: %.1f | Category: %s%n", id, name, score, category);
    }
}

