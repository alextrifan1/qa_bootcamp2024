package Clase;

public class ObjCourse {
    public static void main(String[] args) {
        Car dacia1300 = new Car();
        Car vwPassat = new Car();

        dacia1300.print_car();
        dacia1300.color = "RED";
        dacia1300.car_type = "Sedan";
        dacia1300.cylinder_capacity = 1300;
        dacia1300.model = "dacia 1300";
        dacia1300.car_position = 45;
        dacia1300.print_car();

        dacia1300.start_car();
        dacia1300.increase_speed(20);
        dacia1300.gear_up();
        dacia1300.steer_right(45);
        dacia1300.increase_mileage(5);
        dacia1300.stop_car();
        dacia1300.print_car();

        Square square_abcd = new Square();
        square_abcd.setLength(12);
        System.out.println("sq with side " + square_abcd.getLength() + " has area " + square_abcd.getArea());

    }
}
