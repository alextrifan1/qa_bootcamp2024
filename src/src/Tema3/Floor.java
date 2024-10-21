package Tema3;

import java.util.ArrayList;
import java.util.HashMap;


public class Floor {
    private ArrayList<Room> rooms = new ArrayList<>();
    HashMap<String, Integer> room_count= new HashMap<>();

    public void add_room(Room r) {
       rooms.add(r);
       String rname = r.getRoom_name();
       if (room_count.containsKey(rname)) {
           room_count.put(rname, room_count.get(rname) + 1);
       } else {
           room_count.put(rname, 1);
       }
    }

    @Override
    public String toString() {
        StringBuilder stb = new StringBuilder();

        for (String room_type : room_count.keySet()) {
            int room_number = 1;
            stb.append(room_count.get(room_type)).append(" ").append(room_type).append("\n");

            for (Room r : rooms) {
                if (r.getRoom_name().equals(room_type)) {
                    stb.append("\t").append(room_type).append(" ").append(room_number).append(": ").append(r.toString()).append("\n");
                    room_number++;
                }
            }
        }

        return stb.toString();
    }

}
