package Mostenire;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor @NoArgsConstructor @Getter @Setter
public class Teacher extends Person{

    private String job;

    public void teach_course() {
        System.out.println("teaching at " + this.job);
    }
}
