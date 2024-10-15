package Tema3;

public class Test {
    public static void testRoom() {
        Room r1 = new ConferenceRoom("room1");
        Room r2 = new OfficeSpace("room2");
        Room r3 = new Kitchen("room3");
        Room r4 = new Toilet("room4");
        r1.add_appliances("boiler");
        r2.add_appliances("TV");
        r3.add_appliances("TV");
        r4.add_appliances("boiler");
        r1.add_furniture("desk");
        r2.add_furniture("desk");
        r3.add_furniture("desk");
        r4.add_furniture("desk");
        Floor floor = new Floor();
        floor.add_room(r1);
        floor.add_room(r2);
        floor.add_room(r3);
        floor.add_room(r4);
        System.out.println(floor.toString());
    }
    public static void main(String[] args) {
        testRoom();
    }
}
