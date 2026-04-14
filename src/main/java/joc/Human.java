package joc;

public class Human extends Player{
    public Human(String name, int attackPoints, int defensePoints, int life) {
        super(name, attackPoints, defensePoints, Math.min(life, 100));
    }

}
