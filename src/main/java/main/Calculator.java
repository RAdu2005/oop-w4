package main;

public class Calculator {
    public static double getAverageGrade(Student s){
        double ans = 0;

        int sum = 0;
        for(Grade i : s.gradeList){
            sum += i.courseGrade;
        }

        ans = (sum * 1.0) / s.gradeList.size();
        return ans;
    }

    public static double getMedianGrade(Student s){
        double ans = 0;

        int[] gradeList = new int[1000];
        int index = 0;
        for(Grade i : s.gradeList){
            gradeList[index++] = i.courseGrade;
        }
        
        int aux;
        for(int i = 0; i < index - 1; i++){
            for(int j = i + 1; j < index ; j++){
                if(gradeList[i] > gradeList[j]){
                    aux = gradeList[i];
                    gradeList[i] = gradeList[j];
                    gradeList[j] = aux; 
                }
            }
        }

        if(index % 2 == 1) ans = gradeList[index / 2];
        else ans = (gradeList[index / 2] + gradeList[index / 2 - 1]) / 2.0;   
        
        return ans;
    }
}
