package joc;

import java.util.ArrayList;

public abstract class Player {

    private String name;
    private int attackPoints;
    private int defensePoints;
    private int life;
    private ArrayList<Team> teams;
    private ArrayList<Item> items;

    public Player(String name, int attackPoints, int defensePoints, int life) {
        this.name = name;
        this.attackPoints = attackPoints;
        this.defensePoints = defensePoints;
        this.life = life;
        this.teams = new ArrayList<>();
        this.items = new ArrayList<>();
        System.out.println("He creat un " + this.getClass().getSimpleName());
    }
    public String getName() {
        return name;
    }

    public int getAttackPoints() {
        return attackPoints;
    }

    public int getDefensePoints() {
        return defensePoints;
    }

    public int getLife() {
        return life;
    }
    protected void setAttackPoints(int attackPoints) {
        this.attackPoints = attackPoints;
    }

    protected void setDefensePoints(int defensePoints) {
        this.defensePoints = defensePoints;
    }

    protected void setLife(int life) {
        if (life < 0) {
            this.life = 0;
        } else {
            this.life = life;
        }
    }
    public void addTeam(Team t) {
        if (t != null && !teams.contains(t)) {
            teams.add(t);
            if (!t.getPlayers().contains(this)) {
                t.addPlayer(this);
            }
        }
    }

    public void removeTeam(Team t) {
        if (t != null && teams.contains(t)) {
            teams.remove(t);
            if (t.getPlayers().contains(this)) {
                t.removePlayer(this);
            }
        }
    }


    @Override
    public String toString() {
        String text = name + " PA:" + getTotalAttackPoints()
                + " / PD:" + getTotalDefensePoints()
                + " / PV:" + life
                + " (pertany a " + teams.size() + " equips)";

        if (!items.isEmpty()) {
            text += " té els ítems:\n";
            for (Item item : items) {
                text += item + "\n";
            }
        }

        return text;
    }
    public void attack(Player p) {
        System.out.println("// ABANS DE L'ATAC:");
        System.out.println("Atacant: " + this);
        System.out.println("Atacat: " + p);

        System.out.println("// ATAC:");
        p.hit(this.getTotalAttackPoints());

        if (p.life > 0) {
            this.hit(p.getTotalAttackPoints());
        }

        System.out.println("// DESPRÉS DE L'ATAC:");
        System.out.println("Atacant: " + this);
        System.out.println("Atacat: " + p);
        System.out.println();
    }
    protected void hit(int attackPoints) {
        int defense = getTotalDefensePoints();
        int damage = attackPoints - defense;

        if (damage < 0) {
            damage = 0;
        }

        int oldLife = this.life;
        this.life -= damage;

        if (this.life < 0) {
            this.life = 0;
        }

        System.out.println(
                this.name + " és colpejat amb " + attackPoints +
                        " punts i es defén amb " + defense +
                        ". Vides: " + oldLife + " - " + damage + " = " + this.life
        );
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Player)) return false;

        Player other = (Player) obj;

        return this.name.equals(other.name)
                && this.attackPoints == other.attackPoints
                && this.defensePoints == other.defensePoints
                && this.life == other.life;
    }

    public void addItem(Item item) {
        if (item != null && !items.contains(item)) {
            items.add(item);
        }
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public int getTotalAttackPoints() {
        int total = attackPoints;

        for (Item item : items) {
            total += item.getAttackBonus();
        }

        return total;
    }

    public int getTotalDefensePoints() {
        int total = defensePoints;

        for (Item item : items) {
            total += item.getDefenseBonus();
        }

        return total;
    }

}
