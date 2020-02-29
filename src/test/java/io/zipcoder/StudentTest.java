package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

public class StudentTest {

    @Test
    public void testToString() {
        String fName = "Amber";
        String lName = "Mo";
        Double [] examScores = {100.0,150.0,250.0,0.0};

        Student  testStudent = new Student(fName,lName,examScores);

        String output = testStudent.toString();
        System.out.println(output);
    }

    @Test
    public void getExamScores() {
        String fName = "Amber";
        String lName = "Mo";
        Double [] examScores = {100.0,95.0,85.0,96.0};

        Student  testStudent = new Student(fName,lName,examScores);

        String output = testStudent.getExamScores();

        System.out.println(output);

    }

    @Test
    public void addExamScore() {
        String fName = "Amber";
        String lName = "Mo";
        Double [] examScores = {};
        Student testStudent = new Student(fName,lName,examScores);

        testStudent.addExamScore(100.0);
        String output = testStudent.getExamScores();

        System.out.println(output);

    }

    @Test
    public void getNumberOfExamsTaken() {
        String fName = "Amber";
        String lName = "Mo";
        Double [] examScores = {100.0,95.0,85.0,96.0};

        Student  testStudent = new Student(fName,lName,examScores);

        Integer output = testStudent.getNumberOfExamsTaken();
        Assert.assertEquals(4,output,0.00);
        System.out.println(output);
    }

    @Test
    public void setExamScore() {
        String fName = "Amber";
        String lName = "Mo";
        Double [] examScores = {100.0,95.0,85.0,96.0};

        Student  testStudent = new Student(fName,lName,examScores);

        testStudent.setExamScore(1,85.0);
        String output = testStudent.getExamScores();

        System.out.println(output);
    }

    @Test
    public void getAverageExamScores() {
        String fName = "Amber";
        String lName = "Mo";
        Double [] examScores = {100.0,150.0,250.0,0.0};

        Student  testStudent = new Student(fName,lName,examScores);

        double output = testStudent.getAverageExamScores();

        Assert.assertEquals(125.0,output,0.00);

        System.out.println(output);
    }


}