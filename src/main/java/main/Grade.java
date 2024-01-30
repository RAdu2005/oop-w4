package main;

import java.io.Serializable;

public class Grade implements Serializable {
    String courseName;
    int courseGrade;

    public Grade(String courseName, int courseGrade){
        this.courseName = courseName;
        this.courseGrade = courseGrade;
    }
}
