package inici;

import joc.Alien;
import joc.Human;
import joc.Team;
import joc.Warrior;

public class JocDeRol {

    public static void main(String[] args) {
        provaFaseV4();
    }

    public static void provaFaseV4() {
        Human h = new Human("John Smith", 13, 8, 120);
        Warrior w = new Warrior("Lancelot", 18, 12, 90);
        Alien a = new Alien("Martian PK", 20, 10, 35);

        Team t1 = new Team("Els Guais");
        Team t2 = new Team("Supervivents");

        System.out.println("// JUGADORS CREATS //");
        System.out.println(h);
        System.out.println(w);
        System.out.println(a);
        System.out.println();

        System.out.println("// ASSIGNANT JUGADORS A EQUIPS //");
        t1.addPlayer(h);
        t1.addPlayer(w);
        t2.addPlayer(h);
        t2.addPlayer(a);

        System.out.println(t1);
        System.out.println(t2);

        System.out.println("// JUGADORS DESPRÉS D'ASSIGNAR EQUIPS //");
        System.out.println(h);
        System.out.println(w);
        System.out.println(a);
        System.out.println();

        System.out.println("// LLEVANT UN JUGADOR D'UN EQUIP //");
        t2.removePlayer(h);
        System.out.println(t2);
        System.out.println(h);
        System.out.println();

        System.out.println("// COMPROVANT EQUALS DE PLAYER //");
        Human h2 = new Human("John Smith", 13, 8, 100);
        System.out.println("h.equals(h2) = " + h.equals(h2));
        System.out.println();

        System.out.println("// COMPROVANT EQUALS DE TEAM //");
        Team t3 = new Team("Els Guais");
        t3.addPlayer(h);
        t3.addPlayer(w);
        System.out.println("t1.equals(t3) = " + t1.equals(t3));
    }
}
