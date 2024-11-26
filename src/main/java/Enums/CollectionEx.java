package Enums;

import Clase.Shape;
import Clase.Square;
import Mostenire.Circle;
import Mostenire.Rectangle;
import Mostenire.Student;
import Mostenire.Triangle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class CollectionEx {
    public static void main(String[] args) {
        int[] numbers = {1, 5, 8, 89};
        Shape[] shapes = {new Circle(), new Triangle(), new Rectangle()};

        for (int n : numbers) {
            System.out.println(n);
        }

        for (Shape s : shapes) {
            s.draw();
        }

        Shape[] myShapes = new Shape[10];
        //myShapes[0].draw(); // nullptr exception

        ArrayList myList = new ArrayList();
        myList.add(new Shape());
        myList.add(new Student());
        myList.get(0);

        for (Object o : myList) {
            System.out.println(o);
        }

        Iterator it = myList.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        ArrayList<Shape> myGenericShapes = new ArrayList<Shape>();
        myGenericShapes.add(new Square());
        myGenericShapes.add(new Rectangle());
        for ( Shape s: myGenericShapes) {
            s.draw();
        }

        HashSet<String> hs = new HashSet<String>();
        hs.add("alex");
        hs.add("alex");
        System.out.println(hs.size()); //1
        //String[] array = (String[]) hs.toArray();

        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "alex");
        map.put(1, "andreea");
        System.out.println(map.get(1));

        for (Integer k : map.keySet()) {
            System.out.println(map.get(k));
        }

        String inputText = "Ana are mere si pere si struguri. Toamna e frumos" +
                " pentru ca nu e inca frig.";


    }

    public void printCharFr(HashMap<Character, Integer> charMap) {
        for (Character c: charMap.keySet()) {
            System.out.println(c + " : " + charMap.get(c));
        }
    }

    public static HashMap<Character, Integer> computeMapFromString(String text, boolean caseSensitive) {
        HashMap<Character, Integer> charMap = new HashMap<>();
        String finalText = caseSensitive ? text : text.toLowerCase();
        for (Character c : finalText.toCharArray()) {
            if (charMap.containsKey(c)) {
                charMap.put(c, charMap.get(c)+1);
            } else {
                charMap.put(c, 1);
            }
        }
        return charMap;
    }
}
