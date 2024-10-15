package Mostenire;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor @AllArgsConstructor @Getter @Setter
public class Student extends Person{
    private double[] grades;

    public void take_exam() {
        System.out.println("the student attends the exam");
    }
}
