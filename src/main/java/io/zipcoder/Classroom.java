package io.zipcoder;

import java.sql.Array;
import java.util.HashMap;


public class Classroom {

    Student[] students;


    public Classroom(int maxNumberOfStudents) {
        this.students = new Student[maxNumberOfStudents];
    }

    public Classroom(Student[] students) {
        this.students = students;
    }

    public Classroom() {
        this.students = new Student[30];

    }

    public Student[] getStudents() {
        return this.students;
    }

    public Double getAverageExamScore() {

        double sumOfScores = 0;

        for (int i = 0; i < this.students.length; i++) {
            for (int k = 0; k < this.students[i].testScores.size(); k++)
                sumOfScores += this.students[i].testScores.get(k);
        }

        return sumOfScores / this.students.length;
    }

    public void addStudent(Student newStudent) {

        int pos = 0;

        for (int i = 0; i < this.students.length; i++) {
            if (this.students[i] == null) {
                pos = i;
                break;
            }
        }

        this.students[pos] = newStudent;
    }

    public void removeStudent(String firstName, String lastName) {

        int lastStudentIndex = students.length - 1;
        int indexStudentToBeRemoved = 0;

        for (int i = 0; i < students.length; i++) {
            if (students[i].getFirstName().equals(firstName) && students[i].getLastName().equals(lastName)) {
                indexStudentToBeRemoved = i;
            }
        }

        for (int i = indexStudentToBeRemoved; i < students.length; i++) {
            if (i != students.length - 1) students[i] = students[i + 1];
        }

        students[lastStudentIndex] = null;
    }


    public Student[] getStudentsByScore() {


        double studentOneAverageScore = 0.0;
        double studentTwoAverageScore = 0.0;
        Student tempPosition;
        Student[] tempStudents = new Student[students.length];
        int counter = 0;

        //TODO add lexigraphical sorting

        for (int i = 0; i < students.length; i++) {
            if (students.length > 1) {
                for (int k = i; k < students.length; k++) {
                    studentOneAverageScore = students[i].getAverageExamScore();
                    studentTwoAverageScore = students[k].getAverageExamScore();
                    if (studentOneAverageScore > studentTwoAverageScore) {
                        tempPosition = students[i];
                        students[i] = students[k];
                        students[k] = tempPosition;
                    }
                }
            }
        }

        // reverse the order to make it descending

        for (int i = students.length - 1; i >= 0; i--) {
            tempStudents[counter] = students[i];
            counter++;
        }
        students = tempStudents;
        return students;
    }


    public HashMap getGradeBook() {

        int numOfStudents = this.students.length;
        HashMap map = new HashMap(numOfStudents * 2);


        for (int i = 0; i < numOfStudents; i++) {
            map.put(this.students[i], getStudentAverage(this.students[i], numOfStudents));
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

        getStudentAverage = student.getAverageExamScore();

        if (getStudentAverage >= getAverageExamScore()) {
            return "B";
        } else {
            return "A";
        }
    }
}