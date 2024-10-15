package Mostenire;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor @AllArgsConstructor @Getter @Setter
public class Person {
    private String name;
    private String surname;
    private String date_of_birth;

    public void eat() {
        System.out.println("the person eats healthy every day");
    }

}
