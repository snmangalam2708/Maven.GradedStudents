package io.zipcoder;

import java.util.*;

public class Classroom {
    Student[] allStudents;


    public Classroom(Student[] students) {
        this.allStudents = students;
    }


    public Classroom(int maxNumberOfStudents) {
        this.allStudents = new Student[maxNumberOfStudents];
    }

    public Classroom() {
        this.allStudents = new Student[30];
    }


    public Student[] getStudents() {
        return this.allStudents;
    }

    public double getAverageExamScore() {
        double examScores = 0;

        for (int i = 0; i < this.allStudents.length; i++) {
            for (int k = 0; k < this.allStudents[i].testScores.size(); k++) {
                examScores += this.allStudents[i].testScores.get(k);
            }
        }

        return examScores / this.allStudents.length;
    }

    public void addStudent(Student newStudent) {
        int positionToAddStudent = 0;

        for (int i = 0; i < this.allStudents.length; i++) {
            if (this.allStudents[i] == null) {
                positionToAddStudent = i;
                break;
            }
        }
        this.allStudents[positionToAddStudent] = newStudent;

    }

    public void removeStudent(String firstName, String lastName) {

        int lastStudentIndex = allStudents.length - 1;
        int indexStudentToBeRemoved = 0;

        for (int i = 0; i < allStudents.length; i++) {
            if (allStudents[i].getFirstName().equals(firstName) && allStudents[i].getLastName().equals(lastName)) {
                indexStudentToBeRemoved = i;
            }
        }

        for (int i = indexStudentToBeRemoved; i < allStudents.length; i++) {
            if (i != allStudents.length - 1) allStudents[i] = allStudents[i + 1];
        }

        allStudents[lastStudentIndex] = null;
    }

    public Student[] getStudentsByScore() {
        double studentOneAverageScore = 0.0;
        double studentTwoAverageScore = 0.0;
        Student tempPosition;
        Student[] tempStudents = new Student[allStudents.length];
        int counter = 0;

        //TODO add lexigraphical sorting

        for (int i = 0; i < allStudents.length; i++) {
            if (allStudents.length > 1) {
                for (int k = i; k < allStudents.length; k++) {
                    studentOneAverageScore = allStudents[i].getAverageExamScores();
                    studentTwoAverageScore = allStudents[k].getAverageExamScores();
                    if (studentOneAverageScore > studentTwoAverageScore) {
                        tempPosition = allStudents[i];
                        allStudents[i] = allStudents[k];
                        allStudents[k] = tempPosition;
                    }
                }
            }
        }

        // reverse the order to make it descending
        for (int i = allStudents.length - 1; i >= 0; i--) {
            tempStudents[counter] = allStudents[i];
            counter++;
        }
        allStudents = tempStudents;
        return allStudents;
    }


    public HashMap getGradeBook() {
        int numOfStudents = this.allStudents.length;
        HashMap map = new HashMap(numOfStudents * 2);


        for (int i = 0; i < numOfStudents; i++) {
            map.put(this.allStudents[i], getStudentAverage(this.allStudents[i], numOfStudents));
        }

        return map;
    }

    public String getStudentAverage(Student student, int numberOfStudents) {
        int gradeA = (int) Math.floor((10.0 / 100) * numberOfStudents + 1);
        int gradeBLower = (int) Math.floor((11.0 / 100) * numberOfStudents + 1);
        int gradeBUpper = (int) Math.floor((29.0 / 100) * numberOfStudents + 1);
        int gradeCLower = (int) Math.floor((30.0 / 100) * numberOfStudents + 1);
        int gradeCUpper = (int) Math.floor((50.0 / 100) * numberOfStudents + 1);
        int gradeDLower = (int) Math.floor((51.0 / 100) * numberOfStudents + 1);
        int gradeDUpper = (int) Math.floor((89.0 / 100) * numberOfStudents + 1);

        double getStudentAverage;

        getStudentAverage = student.getAverageExamScores();

        if (getStudentAverage >= getAverageExamScore()) {
            return "B";
        } else {
            return "A";
        }
    }
}