package inici;

import joc.*;
import util.Funcionetes;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class JocDeRol {
    private static ArrayList<Player> players = new ArrayList<>();
    private static ArrayList<Team> teams = new ArrayList<>();
    private static ArrayList<Item> items = new ArrayList<>();
    private static Random random = new Random();
    public static void main(String[] args) {
        menuPrincipal();
    }

    public static void menuPrincipal() {
        int opcio;
        do {
            System.out.println("\n=== JOC DE ROL ===");
            System.out.println("1. Menú jugadors");
            System.out.println("2. Menú equips");
            System.out.println("3. Menú ítems");
            System.out.println("4. Jugar");
            System.out.println("0. Eixir");

            opcio = Funcionetes.lligInt("Opció: ");

            switch (opcio) {
                case 1:
                    menuJugadors();
                    break;
                case 2:
                    menuEquips();
                    break;
                case 3:
                    menuItems();
                    break;
                case 4:
                    jugar();
                    break;
                case 0:
                    System.out.println("Adeu!");
                    break;
                default:
                    System.out.println("Opció incorrecta");
            }

        } while (opcio != 0);
    }
    public static void menuJugadors() {
        int opcio;

        do {
            System.out.println("\n=== MENÚ JUGADORS ===");
            System.out.println("1. Crear jugador");
            System.out.println("2. Llistar jugadors");
            System.out.println("3. Eliminar jugador");
            System.out.println("0. Tornar");

            opcio = Funcionetes.lligInt("Opció: ");


            switch (opcio) {
                case 1:
                    crearJugador();
                    break;
                case 2:
                    llistarJugadors();
                    break;
                case 3:
                    eliminarJugador();
                    break;
                case 0:
                    System.out.println("Tornant...");
                    break;
                default:
                    System.out.println("Opció incorrecta");
            }

        } while (opcio != 0);
    }
    public static void crearJugador() {
        String tipus = Funcionetes.lligText("Tipus de jugador (H/W/A): ");
        String nom = Funcionetes.lligText("Nom: ");
        int pa = Funcionetes.lligInt("Punts d'atac entre 1 i 100: ");

        int pd = 100 - pa;
        int pv = 100;

        Player p = null;

        switch (tipus) {
            case "h":
            case "H":
                p = new Human(nom, pa, pd, pv);
                break;
            case "w":
            case "W":
                p = new Warrior(nom, pa, pd, pv);
                break;
            case "a":
            case "A":
                p = new Alien(nom, pa, pd, pv);
                break;
            default:
                System.out.println("Tipus incorrecte");
        }

        if (p != null) {
            if (!players.contains(p)) {
                players.add(p);
                System.out.println("Jugador creat correctament.");
            } else {
                System.out.println("Ja existeix un jugador igual.");
            }
        }
    }

    public static void llistarJugadors() {
        if (players.isEmpty()) {
            System.out.println("No hi ha jugadors.");
        } else {
            for (Player p : players) {
                System.out.println(p);
            }
        }
    }

    public static void eliminarJugador() {
        String nom = Funcionetes.lligText("Nom del jugador a eliminar: ");

        Player p = buscarJugador(nom);

        if (p != null) {
            players.remove(p);
            System.out.println("Jugador eliminat.");
        } else {
            System.out.println("No existeix cap jugador amb eixe nom.");
        }
    }
    public static void menuEquips() {
        int opcio;

        do {
            System.out.println("\n=== MENÚ EQUIPS ===");
            System.out.println("1. Crear equip");
            System.out.println("2. Llistar equips");
            System.out.println("3. Eliminar equip");
            System.out.println("4. Assignar jugador a equip");
            System.out.println("5. Llevar jugador d'equip");
            System.out.println("0. Tornar");

            opcio = Funcionetes.lligInt("Opció: ");

            switch (opcio) {
                case 1:
                    crearEquip();
                    break;
                case 2:
                    llistarEquips();
                    break;
                case 3:
                    eliminarEquip();
                    break;
                case 4:
                    assignarJugadorAEquip();
                    break;
                case 5:
                    llevarJugadorDEquip();
                    break;
                case 0:
                    System.out.println("Tornant...");
                    break;
                default:
                    System.out.println("Opció incorrecta");
            }

        } while (opcio != 0);
    }
    public static void crearEquip() {
        String nom = Funcionetes.lligText("Nom de l'equip: ");

        Team t = new Team(nom);

        if (!teams.contains(t)) {
            teams.add(t);
            System.out.println("Equip creat.");
        } else {
            System.out.println("Ja existeix un equip igual.");
        }
    }

    public static void llistarEquips() {
        if (teams.isEmpty()) {
            System.out.println("No hi ha equips.");
        } else {
            for (Team t : teams) {
                System.out.println(t);
            }
        }
    }

    public static void eliminarEquip() {
        String nom = Funcionetes.lligText("Nom de l'equip a eliminar: ");

        Team t = buscarEquip(nom);

        if (t != null) {
            teams.remove(t);
            System.out.println("Equip eliminat.");
        } else {
            System.out.println("No existeix cap equip amb eixe nom.");
        }
    }

    public static void assignarJugadorAEquip() {

        String nomJugador = Funcionetes.lligText("Nom del jugador: ");

        String nomEquip = Funcionetes.lligText("Nom de l'equip: ");

        Player p = buscarJugador(nomJugador);
        Team t = buscarEquip(nomEquip);
        if (p != null && t != null) {
            try {
                t.addPlayer(p);
                System.out.println("Jugador assignat a l'equip.");
            } catch (JocException e) {
                System.out.println("ERROR: " + e.getMessage());
            }
        } else {
            System.out.println("Jugador o equip no trobat.");
        }
    }

    public static void llevarJugadorDEquip() {
        String nomJugador = Funcionetes.lligText("Nom del jugador: ");

        System.out.print("Nom de l'equip: ");
        String nomEquip = Funcionetes.lligText("Nom de l'equip: ");

        Player p = buscarJugador(nomJugador);
        Team t = buscarEquip(nomEquip);

        if (p != null && t != null) {
            try {
                t.removePlayer(p);
                System.out.println("Jugador llevat de l'equip.");
            } catch (JocException e) {
                System.out.println("ERROR: " + e.getMessage());
            }
        } else {
            System.out.println("Jugador o equip no trobat.");
        }
    }
    public static void menuItems() {
        int opcio;

        do {
            System.out.println("\n=== MENÚ ÍTEMS ===");
            System.out.println("1. Crear ítem");
            System.out.println("2. Llistar ítems");
            System.out.println("3. Eliminar ítem");
            System.out.println("4. Assignar ítem a jugador");
            System.out.println("0. Tornar");
            System.out.print("Opció: ");

            opcio = Funcionetes.lligInt("Opció: ");

            switch (opcio) {
                case 1:
                    crearItem();
                    break;
                case 2:
                    llistarItems();
                    break;
                case 3:
                    eliminarItem();
                    break;
                case 4:
                    assignarItemAJugador();
                    break;
                case 0:
                    System.out.println("Tornant...");
                    break;
                default:
                    System.out.println("Opció incorrecta");
            }
        } while (opcio != 0);
    }
    public static void crearItem() {
        String nom = Funcionetes.lligText("Nom de l'ítem: ");

        int ba = Funcionetes.lligInt("Bonus d'atac: ");

        int bd = Funcionetes.lligInt("Bonus de defensa: ");

        Item item = new Item(nom, ba, bd);
        items.add(item);

        System.out.println("Ítem creat.");
    }

    public static void llistarItems() {
        if (items.isEmpty()) {
            System.out.println("No hi ha ítems.");
        } else {
            for (Item item : items) {
                System.out.println(item);
            }
        }
    }

    public static void eliminarItem() {
        String nom = Funcionetes.lligText("Nom de l'ítem a eliminar: ");

        Item item = buscarItem(nom);

        if (item != null) {
            items.remove(item);
            System.out.println("Ítem eliminat.");
        } else {
            System.out.println("No existeix cap ítem amb eixe nom.");
        }
    }

    public static void assignarItemAJugador() {
        String nomJugador = Funcionetes.lligText("Nom del jugador: ");

        String nomItem = Funcionetes.lligText("Nom de l'ítem: ");

        Player p = buscarJugador(nomJugador);
        Item item = buscarItem(nomItem);

        if (p != null && item != null) {
            p.addItem(item);
            System.out.println("Ítem assignat al jugador.");
        } else {
            System.out.println("Jugador o ítem no trobat.");
        }
    }

    public static void jugar() {
        ArrayList<Player> vius = new ArrayList<>();

        for (Player p : players) {
            if (p.getLife() > 0) {
                vius.add(p);
            }
        }

        while (vius.size() >= 2) {
            Player atacant = vius.get(random.nextInt(vius.size()));
            Player atacat;

            do {
                atacat = vius.get(random.nextInt(vius.size()));
            } while (atacant == atacat);

            try {
                atacant.attack(atacat);
            } catch (JocException e) {
                System.out.println("ERROR: " + e.getMessage());
            }

            vius.clear();
            for (Player p : players) {
                if (p.getLife() > 0) {
                    vius.add(p);
                }
            }
        }

        if (vius.size() == 1) {
            System.out.println("Guanyador: " + vius.get(0));
        } else {
            System.out.println("No hi ha prou jugadors vius.");
        }
    }

    public static Player buscarJugador(String nom) {
        for (Player p : players) {
            if (p.getName().equalsIgnoreCase(nom)) {
                return p;
            }
        }
        return null;
    }

    public static Team buscarEquip(String nom) {
        for (Team t : teams) {
            if (t.getName().equalsIgnoreCase(nom)) {
                return t;
            }
        }
        return null;
    }

    public static Item buscarItem(String nom) {
        for (Item item : items) {
            if (item.getName().equalsIgnoreCase(nom)) {
                return item;
            }
        }
        return null;
    }
}

