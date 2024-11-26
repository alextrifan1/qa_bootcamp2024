package Clase;

import Mostenire.AbstractShape;
import Mostenire.Ishape;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor @AllArgsConstructor
public class Shape extends AbstractShape implements Ishape {

    @Getter@Setter
    private String color;

    public void draw() {
        System.out.println("Drawing a shape");
    }

    public void erase() {
        System.out.println("Erasing a shape");
    }

    @Override
    public void my_meth() {

    }
}
