package Tema3;


/*
    ToDo: o implementare mai buna pentru enums
    ToDo: modul de adaugare al claselor e cam grosolan
    ToDo: teste
 */

public class Main {

    enum FurnitureType { desks, seats, tables, }

    enum Appliances { coffe_machine, fridge, water_dispenser, TV, telepresence, vidoe_projector, }

    public static void main(String[] args) {
        Building building = new Building();
        Floor floor1 = new Floor();
        Floor floor2 = new Floor();
        Floor floor3 = new Floor();
        load_first_floor(floor1);
        load_second_floor(floor2);
        load_third_floor(floor3);

        building.add_floor(floor1);
        building.add_floor(floor2);
        building.add_floor(floor3);
        System.out.println(building.toString());
    }

    private static void load_first_floor(Floor floor1) {
        OfficeSpace of = new OfficeSpace("Office");
        for(int i = 1; i <= 20; i++) {
            of.add_furniture(String.valueOf(FurnitureType.desks));
        }
        Toilet t = new Toilet("Toilet");
        Kitchen k = new Kitchen("Kitchen");
        k.add_appliances(Appliances.coffe_machine.toString());
        k.add_appliances(Appliances.water_dispenser.toString());
        k.add_appliances(Appliances.fridge.toString());
        ConferenceRoom cf1 = new ConferenceRoom("Conference Room");
        cf1.add_appliances(Appliances.TV.toString());
        ConferenceRoom cf2 = new ConferenceRoom("Conference Room");
        cf2.add_appliances(Appliances.TV.toString());
        ConferenceRoom cf3 = new ConferenceRoom("Conference Room");
        cf3.add_appliances(Appliances.TV.toString());

        for (int i = 1; i <= 10; i++) {
            cf1.add_furniture(FurnitureType.desks.toString());
            cf2.add_furniture(FurnitureType.desks.toString());
            cf3.add_furniture(FurnitureType.desks.toString());
        }

        floor1.add_room(of);
        floor1.add_room(t);
        floor1.add_room(t);
        floor1.add_room(k);
        floor1.add_room(cf1);
        floor1.add_room(cf2);
        floor1.add_room(cf3);
    }
    private static void load_second_floor(Floor floor2) {
        OfficeSpace of1 = new OfficeSpace("Office");
        OfficeSpace of2 = new OfficeSpace("Office");
        for (int i = 1; i <= 10; i++) {
            of1.add_furniture(FurnitureType.desks.toString());
            of2.add_furniture(FurnitureType.desks.toString());
        }

        Kitchen k = new Kitchen("Kitchen");
        k.add_appliances(Appliances.coffe_machine.toString());
        k.add_appliances(Appliances.water_dispenser.toString());
        k.add_appliances(Appliances.fridge.toString());

        Toilet t1 = new Toilet("Toilet");
        Toilet t2 = new Toilet("Toilet");

        ConferenceRoom cf1 = new ConferenceRoom("Conference Room");
        cf1.add_appliances(Appliances.TV.toString());
        ConferenceRoom cf2 = new ConferenceRoom("Conference Room");
        cf2.add_appliances(Appliances.TV.toString());
        ConferenceRoom cf3 = new ConferenceRoom("Conference Room");
        cf3.add_appliances(Appliances.TV.toString());
        ConferenceRoom cf4 = new ConferenceRoom("Conference Room");
        cf4.add_appliances(Appliances.TV.toString());

        for (int i = 1; i <= 8; i++) {
            cf1.add_furniture(FurnitureType.seats.toString());
            cf2.add_furniture(FurnitureType.seats.toString());
            cf3.add_furniture(FurnitureType.seats.toString());
            cf4.add_furniture(FurnitureType.seats.toString());
        }

        floor2.add_room(of1);
        floor2.add_room(of2);
        floor2.add_room(t1);
        floor2.add_room(t2);
        floor2.add_room(k);
        floor2.add_room(cf1);
        floor2.add_room(cf2);
        floor2.add_room(cf3);
        floor2.add_room(cf4);

    }
    private static void load_third_floor(Floor floor3) {
        Toilet t1 = new Toilet("Toilet");
        Toilet t2 = new Toilet("Toilet");

        ConferenceRoom cf1 = new ConferenceRoom("Conference Room");
        cf1.add_appliances(Appliances.vidoe_projector.toString());
        cf1.add_appliances(Appliances.telepresence.toString());
        ConferenceRoom cf2 = new ConferenceRoom("Conference Room");
        cf2.add_appliances(Appliances.TV.toString());
        cf2.add_appliances(Appliances.telepresence.toString());
        ConferenceRoom cf3 = new ConferenceRoom("Conference Room");
        cf3.add_appliances(Appliances.TV.toString());
        cf3.add_appliances(Appliances.telepresence.toString());
        ConferenceRoom cf4 = new ConferenceRoom("Conference Room");
        cf4.add_appliances(Appliances.TV.toString());
        cf4.add_appliances(Appliances.telepresence.toString());
        ConferenceRoom cf5 = new ConferenceRoom("Conference Room");
        cf5.add_appliances(Appliances.TV.toString());
        cf5.add_appliances(Appliances.telepresence.toString());
        ConferenceRoom cf6 = new ConferenceRoom("Conference Room");
        cf6.add_appliances(Appliances.TV.toString());
        cf6.add_appliances(Appliances.telepresence.toString());

        // Adding seats for each conference room
        for (int i = 1; i <= 30; i++) {
            cf1.add_furniture(FurnitureType.seats.toString());
        }
        for (int i = 1; i <= 20; i++) {
            cf2.add_furniture(FurnitureType.seats.toString());
        }
        for (int i = 1; i <= 10; i++) {
            cf3.add_furniture(FurnitureType.seats.toString());
            cf4.add_furniture(FurnitureType.seats.toString());
            cf5.add_furniture(FurnitureType.seats.toString());
            cf6.add_furniture(FurnitureType.seats.toString());
        }

        // Add rooms to third floor
        floor3.add_room(t1);
        floor3.add_room(t2);
        floor3.add_room(cf1);
        floor3.add_room(cf2);
        floor3.add_room(cf3);
        floor3.add_room(cf4);
        floor3.add_room(cf5);
        floor3.add_room(cf6);
    }
}
