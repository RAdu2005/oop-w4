package main;

import java.io.Serializable;
import java.util.ArrayList;

public class Student implements Serializable {
    String name;
    int no;

    public Student(String studentName, int studentNo){
        this.name = studentName;
        this.no = studentNo;
    }

    ArrayList<Grade> gradeList = new ArrayList<>();

    public void addGrade(String course, int grade){
        gradeList.add(new Grade(course, grade));
    }

    public void listCompletions(){
        for(Grade i : gradeList){
            System.out.println(i.courseName + ": " + i.courseGrade);
        }
    }

}
