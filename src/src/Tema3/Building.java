package Tema3;

import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

@NoArgsConstructor
public class Building {
    ArrayList<Floor> floors = new ArrayList<>();

    public void add_floor(Floor f) {
       floors.add(f);
    }
    @Override
    public String toString() {
        StringBuilder stb = new StringBuilder();
        int fn = 1;
        for (Floor f : floors) {
            stb.append("Floor ").append(fn).append(":\n");
            stb.append(f.toString()).append("\n");
            fn++;
        }
        return stb.toString();
    }
}
