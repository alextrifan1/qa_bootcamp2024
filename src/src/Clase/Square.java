package Clase;

import Mostenire.Rectangle;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
public class Square extends Rectangle {

   /* @Getter @Setter
    private double side;*/
    //private static int ceva = 0;

    public Square(double side) {
        super(side, side);
    }

    public double getArea() {
        return super.getArea();
        //    return Math.pow(side, 2);
    }

    public void printCurrentSquare() {
        System.out.println("Square with side " + this.getLength() + " has area of " + getArea());
    }

    @Override
    public void draw() {
        System.out.println("drawing a square");
    }

    @Override
    public String toString() {
        return "My square has 4 sides each " + this.getLength();
    }
}

