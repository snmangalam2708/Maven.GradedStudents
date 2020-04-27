package io.zipcoder;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Collections;

public class Student {

    String firstName;
    String lastName;
    ArrayList<Double> testScores = new ArrayList<>();


    public Student(String firstName, String lastName, Double[] examScores) {
        this.firstName = firstName;
        this.lastName = lastName;
        Collections.addAll(this.testScores, examScores);
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getNumberOfExamsTaken() {

        System.out.println("Exams taken :");
        return this.testScores.size();
    }

    public String getExamScores() {

        String examScores = "";

        for (int i=0; i<testScores.size(); i++){
            int examID = i+1;
            examScores += formatString(examID, testScores.get(i));
        }
        return examScores;
    }

    public void addExamScore(double examScore){

        this.testScores.add(examScore);
        System.out.println("\n Score added : " + examScore);

    }

    public void setExamScore(int examNumber, double newScore){

        this.testScores.set(examNumber-1,newScore);

    }

    public Double getAverageExamScore(){

        double sumOfScores = 0.0 ;

        for (int i = 0; i< this.testScores.size(); i++){

            sumOfScores += this.testScores.get(i);
        }

        System.out.println("Average exam Scores :");
        return (sumOfScores)/this.testScores.size();
    }

    @Override
    public String toString() {
        String result = getExamScores();

        return "Student Name: " + this.firstName + " " + this.lastName + "\n" +
                "Exam Scores:\n\n" + result;
    }

    public String formatString(int id, Double testscore){

        return "\t" + " Exam: " + (id) + " -> " + String.format("%.0f", testscore) + "\n";
    }
}