package io.zipcoder;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class ClassroomTest {

    @Test
    public void getStudents() {
        Double[] student1Scores = {100.0, 150.0, 95.0};
        Double[] student2Scores = {225.0, 25.0};

        Student student1 = new Student("student1", "one", student1Scores);
        Student student2 = new Student("student2", "two", student2Scores);

        Student[] allStudents = {student1, student2};
        Classroom testClassroom = new Classroom(allStudents);

        Student[] classroomStudents = testClassroom.getStudents();
        int expected = 3;
        int actual = classroomStudents[0].getNumberOfExamsTaken();
        System.out.println("Exams taken by "+ student1.getFirstName() + " : " + actual);
        Assert.assertEquals(expected, actual);

        expected = 2;
        actual = classroomStudents[1].getNumberOfExamsTaken();
        System.out.println("Exams taken by "+ student2.getFirstName() + " : " + actual);
        Assert.assertEquals(expected, actual);
    }


    @Test
    public void testGetAverageExamScore() {
        Double[] student1Scores = {100.0, 150.0};
        Double[] student2Scores = {225.0, 225.0};

        Student student1 = new Student("student1", "one", student1Scores);
        Student student2 = new Student("student2", "two", student2Scores);

        Student[] allStudents = {student1, student2};
        Classroom testClassroom = new Classroom(allStudents);
        Student[] classroomStudents = testClassroom.getStudents();

        double expected1 = 125.0;
        double actual1 = classroomStudents[0].getAverageExamScores();
        System.out.println("Average score by "+ student1.getFirstName() + " : " + actual1);

        Assert.assertEquals(expected1, actual1, 0.0);


        double expected = 225.0;
        double actual = classroomStudents[1].getAverageExamScores();
        System.out.println("Average score by "+ student2.getFirstName() + " : " + actual);

        Assert.assertEquals(expected, actual, 0.0);
    }


    @Test
    public void addStudent() {
        int maxNumberOfStudents = 3;
        Classroom classroom = new Classroom(maxNumberOfStudents);
        Double[] student1Scores = {100.0, 175.0, 70.0};
        Double[] student2Scores = {225.0, 25.0, 170.0};
        Double[] student3Scores = {50.0, 50.0, 50.0};

        Student[] preEnrollment = classroom.getStudents();
        String preEnrollmentAsString = Arrays.toString(preEnrollment);
        System.out.println("===========================");
        System.out.println(preEnrollmentAsString);

        Student student1 = new Student("Leon", "Hunter", student1Scores);
        classroom.addStudent(student1);

        Student student2 = new Student("Jeff", "Hunter", student2Scores);
        classroom.addStudent(student2);

        Student student3 = new Student("John", "Hunter", student3Scores);
        classroom.addStudent(student3);

        Student[] postEnrollment = classroom.getStudents();
        String postEnrollmentAsString = Arrays.toString(postEnrollment);

        System.out.println("===========================\n");
        System.out.println(postEnrollmentAsString);
    }

    @Test
    public void removeStudent() {
        Double[] student1Scores = {100.0, 175.0, 70.0};
        Double[] student2Scores = {225.0, 25.0, 170.0};
        Double[] student3Scores = {50.0, 50.0, 50.0};
        Double[] student4Scores = {200.0, 80.0, 80.0};

        Student student1 = new Student("Mary", "one", student1Scores);
        Student student2 = new Student("George", "two", student2Scores);
        Student student3 = new Student("Sheldon", "three", student3Scores);
        Student student4 = new Student("Missy", "four", student4Scores);

        Student[] allStudents = {student1, student2, student3, student4};
        Classroom testClassroom = new Classroom(allStudents);
        testClassroom.removeStudent("Mary", "one");

        Student[] postEnrollment = testClassroom.getStudents();
        String postEnrollmentAsString = Arrays.toString(postEnrollment);

        System.out.println("===========================");
        System.out.println(postEnrollmentAsString);

    }

    @Test
    public void getStudentsByScore() {
        Double[] student1Scores = {100.0, 175.0, 70.0};
        Double[] student2Scores = {225.0, 25.0, 170.0};
        Double[] student3Scores = {50.0, 50.0, 50.0};
        Double[] student4Scores = {200.0, 80.0, 80.0};

        Student student1 = new Student("student", "one", student1Scores);
        Student student2 = new Student("student", "two", student2Scores);
        Student student3 = new Student("student", "three", student3Scores);
        Student student4 = new Student("student", "four", student4Scores);

        Student[] allStudents = {student1, student2, student3, student4};
        Classroom testClassroom = new Classroom(allStudents);

        Student[] postEnrollment = testClassroom.getStudentsByScore();
        String postEnrollmentAsString = Arrays.toString(postEnrollment);

        System.out.println("===========================");
        System.out.println(postEnrollmentAsString);
    }

    @Test
    public void getGradeBook() {

        Double[] examScores1 = {99.0, 50.0, 82.0}; // 77
        Double[] examScores2 = {225.0, 25.0, 170.0}; // 140
        Double[] examScores3 = {50.0, 50.0, 50.0}; // 50
        Double[] examScores4 = {100.0, 84.0, 62.0}; // 82
        Double[] examScores5 = {60.0, 50.0, 40.0}; // 50

        Student student1 = new Student("One", "Hunter", examScores1);
        Student student2 = new Student("Two", "Smith", examScores2);
        Student student3 = new Student("Three", "Jones", examScores3);
        Student student4 = new Student("Four", "Brown", examScores4);
        Student student5 = new Student("Five", "Ambron", examScores5);

        Student[] students = {student1,student2,student3,student4, student5};
        Classroom classroom = new Classroom(students);

        Map output = classroom.getGradeBook();
        System.out.println(output);
    }

    @Test
    public void testMath (){
        int gradeA = (int) Math.floor((10.0/100) * 15 + 1);
        int gradeBLower = (int) Math.floor((11.0/100) * 15 + 1);
        int gradeBUpper = (int) Math.floor((10.0/100) * 15 + 1);
        int gradeCLower = (int) Math.floor((20.0/100) * 15 + 1);
        System.out.println(gradeA);
        System.out.println(gradeBLower);
        System.out.println(gradeBUpper);
        System.out.println(gradeCLower);

    }
}