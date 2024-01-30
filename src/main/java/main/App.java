package main;

import java.util.Scanner;

public class App 
{
    public static void main( String[] args )
    {
        Scanner sc = new Scanner(System.in);
        University myUniversity = new University();

        while(true){
            System.out.println("1) Add student, 2) List students, 3) Add course completion for student, 4) List course completions of student, 5) Calculate the average of course completions, 6) Calculate median of course completions, 7) Save students to file, 8) Load students from file, 0) End the program");
            int option = Integer.parseInt(sc.nextLine());

            switch(option){
                case 1: {
                    System.out.println("What is the name of the student?");
                    String name = sc.nextLine();

                    System.out.println("What is the student number of the student?");
                    int sno = Integer.parseInt(sc.nextLine());

                    myUniversity.addStudents(name, sno);
                    break;
                }case 2: {
                    myUniversity.listStudents(true);
                    break;
                }case 3: {
                    myUniversity.listStudents(false);

                    System.out.println("Which student do you want to add course completion for?");
                    int index = Integer.parseInt(sc.nextLine());

                    System.out.println("What is the name of the course?");
                    String courseName = sc.nextLine();

                    System.out.println("What is the grade of the course?");
                    int courseGrade = Integer.parseInt(sc.nextLine());

                    myUniversity.addCompletion(index, courseName, courseGrade);

                    break;
                }case 4: {
                    myUniversity.listStudents(false);

                    System.out.println("Which student do you want to list course completions for?");
                    int index = Integer.parseInt(sc.nextLine());

                    myUniversity.listCompletions(index);
                    break;
                }case 5:{
                    myUniversity.listStudents(false);

                    System.out.println("Which student do you want to calculate the average for?");
                    int index = Integer.parseInt(sc.nextLine());

                    myUniversity.calculateAverage(index);
                    break;
                }case 6: {
                    myUniversity.listStudents(false);

                    System.out.println("Which student do you want to calculate the median for?");
                    int index = Integer.parseInt(sc.nextLine());

                    myUniversity.calculateMedian(index);
                    break;
                }case 0: {
                    System.out.println("Thank you for using the program.");
                    sc.close();
                    System.exit(0);
                    return;
                }default:
                    System.out.println("Wrong input value!");
                    break;                    
            }
        }
    }
}
