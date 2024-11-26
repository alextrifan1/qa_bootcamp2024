package Clase;

import Mostenire.Rectangle;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class Car {
    String model;
    String color;
    String car_type;
    double MAX_SPEED = 180;
    double current_speed;
    float cylinder_capacity;
    float current_mileage;
    double car_position; //compared to magnetic nord
    int MAX_GEAR = 6;
    int current_gear;

    public void start_car() {
        current_gear = 1;
        current_speed = 5;
    }

    public void steer_left(float angle) {
        car_position -= angle;
    }

    public void steer_right(float angle) {
        car_position += angle;
    }

    public void stop_car() {
        current_speed = 0;
        current_gear = 0;
    }

    public void increase_mileage(float mileage) {
        current_gear += mileage;
    }

    public void increase_speed(double speed_delta) {
        if (current_speed + speed_delta > MAX_SPEED) {
            current_speed = MAX_SPEED;
        } else {
            current_speed += speed_delta;
        }
    }

    public void decelerate_speed(double speed_delta) {
        if (current_speed - speed_delta < 0) {
            current_speed = 0;
        } else {
            current_speed -= speed_delta;
        }
    }

    public void gear_up() {
        if (current_gear < MAX_GEAR) {
            current_gear++;
        }
    }

    public void gear_down() {
        if (current_gear > 0) {
            current_gear--;
        }
    }

    public void print_car() {
        System.out.println("---------------------");
        System.out.println(model);
        System.out.println(color);
        System.out.println(car_type);
        System.out.println(car_position);
        System.out.println(current_mileage);
        System.out.println(current_gear);
        System.out.println(current_speed);
    }
}
