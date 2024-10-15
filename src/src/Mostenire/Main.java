package Mostenire;

import Clase.Car;
import Clase.Shape;
import Clase.Square;

public class Main {
    public static void main(String[] args) {
        Shape my_shape = new Shape();
        my_shape.draw();
        my_shape.erase();
        my_shape.setColor("Green");
        System.out.println("the shape has color: " + my_shape.getColor());

        Rectangle my_rectangle = new Rectangle(4, 5);
        my_rectangle.getPerimeter();
        my_rectangle.draw();

        Square my_square = new Square(12);
        my_square.draw();
        System.out.println("diagonal is " + my_square.getDiagonal());

    }
}
