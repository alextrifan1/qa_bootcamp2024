package Tema3;


import lombok.*;

import java.util.ArrayList;
import java.util.HashMap;

@AllArgsConstructor @RequiredArgsConstructor
public class Room {
    @Getter @Setter @NonNull
    private String room_name;
    private HashMap<String, Integer> furniture = new HashMap<>();
    private HashMap<String, Integer> appliances = new HashMap<>();

    public void add_furniture(String fu) {
        if (furniture.containsKey(fu)) {
            furniture.put(fu, furniture.get(fu)+1);
        } else {
            furniture.put(fu, 1);
        }
    }
    public void add_appliances(String app) {
        if (appliances.containsKey(app)) {
            appliances.put(app, appliances.get(app)+1);
        } else {
            appliances.put(app, 1);
        }
    }

    @Override
    public String toString() {
        StringBuilder stb = new StringBuilder();


        for(String s : furniture.keySet()) {
            stb.append(furniture.get(s)).append(" ").append(s).append(" ");
        }
        for(String s : appliances.keySet()) {
            stb.append(appliances.get(s)).append(" ").append(s).append(" ");
        }
        return stb.toString();
    }
}
