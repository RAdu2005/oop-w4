package main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class University implements Serializable{
    public University(){}
    
    final private String FILENAME = "students.data";
    ArrayList<Student> studentList = new ArrayList<>();

    public void addStudents(String name, int sno){
        studentList.add(new Student(name, sno));
    }

    public void listStudents(boolean printNo){
        if(printNo){ System.out.println("Students:"); }
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

    public void saveStudents(){
        try{
            ObjectOutputStream studentWriter = new ObjectOutputStream(new FileOutputStream(FILENAME));
            studentWriter.writeObject(studentList);
            studentWriter.close();
        }catch(IOException e){
            System.out.println("Saving students failed");
            e.printStackTrace();
        }
    }

    public void loadStudents(){
        try{
            ObjectInputStream studentReader = new ObjectInputStream(new FileInputStream(FILENAME));
            studentList = (ArrayList<Student>) studentReader.readObject();
            studentReader.close();      
        }catch(IOException e){
            System.out.println("Loading students failed");
            e.printStackTrace();
        }catch(ClassNotFoundException e){
            System.out.println("Loading students failed");
            e.printStackTrace();
        }
    }
}
