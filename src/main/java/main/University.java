package main;

import java.io.Serializable;
import java.util.ArrayList;

public class University implements Serializable{
    public University(){}

    ArrayList<Student> studentList = new ArrayList<>();

    public void addStudents(String name, int sno){
        studentList.add(new Student(name, sno));
    }

    public void listStudents(boolean printNo){
        System.out.println("Students:");
        int index = 0;
        for(Student i : studentList){
            if(printNo){ System.out.println(i.no + ": " + i.name); }
            else{
                System.out.println(index++ + ": " + i.name);
            }
        }
    }

    public void addCompletion(int index, String courseName, int courseGrade){
        studentList.get(index).addGrade(courseName, courseGrade);
    }

    public void listCompletions(int index){
        studentList.get(index).listCompletions();
    }

    public void calculateAverage(int index){
        double avg = Calculator.getAverageGrade(studentList.get(index));
        System.out.println("Average is " + avg);
    }

    public void calculateMedian(int index){
        double avg = Calculator.getMedianGrade(studentList.get(index));
        System.out.println("Median is " + avg);
    }
}
