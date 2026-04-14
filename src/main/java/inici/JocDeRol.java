package inici;

import joc.Alien;
import joc.Human;
import joc.Warrior;

public class JocDeRol {

    public static void main(String[] args) {
        provaFaseV2();
    }

    public static void provaFaseV2() {
        Human h = new Human("John Smith", 13, 8, 39);
        Alien a = new Alien("Martian PK", 27, 2, 32);

        System.out.println("// JUGADORS CREATS //");
        System.out.println(h);
        System.out.println(a);
        System.out.println();

        h.attack(a);
        a.attack(h);
    }
}
