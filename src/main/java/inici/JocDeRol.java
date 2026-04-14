package inici;

import joc.Alien;
import joc.Human;
import joc.Warrior;

public class JocDeRol {

    public static void main(String[] args) {
        provaFaseV3();
    }

    public static void provaFaseV3() {
        Human h = new Human("John Smith", 13, 8, 120);
        Warrior w = new Warrior("Lancelot", 18, 12, 90);
        Alien a = new Alien("Martian PK", 20, 10, 35);

        System.out.println("// JUGADORS CREATS //");
        System.out.println(h);
        System.out.println(w);
        System.out.println(a);
        System.out.println();

        System.out.println("// COMPROVANT HUMAN (vida màxima 100) //");
        System.out.println(h);
        System.out.println();

        System.out.println("// ATAC 1: Alien ataca Human //");
        a.attack(h);

        System.out.println("// ATAC 2: Alien torna a atacar Warrior //");
        a.attack(w);

        System.out.println("// ATAC 3: Human ataca Warrior //");
        h.attack(w);

        System.out.println("// ESTAT FINAL //");
        System.out.println(h);
        System.out.println(w);
        System.out.println(a);
    }
}
