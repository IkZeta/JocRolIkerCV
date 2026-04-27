package joc;

public class Item {

    private String name;
    private int attackBonus;
    private int defenseBonus;

    public Item(String name, int attackBonus, int defenseBonus) {
        this.name = name;
        this.attackBonus = attackBonus;
        this.defenseBonus = defenseBonus;
    }

    public String getName() {
        return name;
    }

    public int getAttackBonus() {
        return attackBonus;
    }

    public int getDefenseBonus() {
        return defenseBonus;
    }

    @Override
    public String toString() {
        return "- " + name + " BA:" + attackBonus + " / BD:" + defenseBonus;
    }
}