package inici;

import joc.*;

public class JocDeRol {

    public static void main(String[] args) {
        provaFaseV5();
    }

    public static void provaFaseV5() {
        Human h = new Human("John Smith", 13, 8, 120);
        Warrior w = new Warrior("Lancelot", 18, 12, 90);
        Alien a = new Alien("Martian PK", 20, 10, 35);

        Item sunglasses = new Item("Sunglasses", -1, -1);
        Item falseNails = new Item("False Nails", 5, 2);
        Item shield = new Item("Wood Shield", 0, 6);

        h.addItem(sunglasses);
        h.addItem(falseNails);
        w.addItem(shield);

        System.out.println("// JUGADORS AMB ÍTEMS //");
        System.out.println(h);
        System.out.println(w);
        System.out.println(a);

        System.out.println("// COMBAT //");
        h.attack(a);
        a.attack(w);
    }
}
