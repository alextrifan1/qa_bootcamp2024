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

        Shape s1 = new Triangle();
        Shape s2 = new Circle();
        Shape s3 = new Square();

        s1.draw();
        s2.draw();
        s3.draw();

        Person t1 = new Teacher("UPB"); // nu poate apela metode din teacher, doar din person
        t1.setName("Alex");
        t1.setSurname("G");
        t1.eat();
        ((Teacher)t1).teach_course(); // cast

        Person stud1 = new Student();
        stud1.setSurname("Studentscu");
        stud1.setName("Andrei");

        if (stud1.getName() == null) {
            throw new IllegalArgumentException("no name for student");
        }

        stud1.eat();
        ((Student)stud1).take_exam();

        try {
            my_exception_meth();
        } catch (IllegalArgumentException ex) {
            System.out.println("oops " + ex.getMessage() );
        } catch (Exception ex) {
            System.out.println("generic exception");
        }
        finally {
            System.out.println("this line will always execute");
        }
    }

    public static void my_exception_meth() throws  IllegalArgumentException{
        Student stud1 = new Student();

        if (stud1.getName() == null) {
            throw new IllegalArgumentException("EXception: no name fo student");
        }
    }
}
