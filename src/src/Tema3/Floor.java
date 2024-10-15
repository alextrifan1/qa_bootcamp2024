package Tema3;

import java.util.ArrayList;
import java.util.HashMap;

public class Floor {
    private ArrayList<Room> rooms = new ArrayList<>();
    HashMap<String, Integer> rooms_count= new HashMap<>();

    public void add_room(Room r) {
       rooms.add(r);
    }

    @Override
    public String toString() {
        StringBuilder stb = new StringBuilder();
        for (Room r : rooms) {

            stb.append(r.toString()).append("\n");
        }
        return stb.toString();
    }

}
