package inici;

import joc.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class JocDeRol {
    public static void provaFase1(){
        System.out.println("Creant Humà...");
        Human h = new Human();

        System.out.println("Creant Guerrer...");
        Warrior w = new Warrior();

        System.out.println("Creant Alien...");
        Alien a = new Alien();
    }
    public static void main(String[] args) {
        provaFase1();
    }
}
