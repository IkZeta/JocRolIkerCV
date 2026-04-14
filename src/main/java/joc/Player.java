package joc;

public abstract class Player {
    private String name;
    private int attackPoints;
    private int defensePoints;
    private int life;
    public Player(String name, int attackPoints, int defensePoints, int life) {
        this.name = name;
        this.attackPoints = attackPoints;
        this.defensePoints = defensePoints;
        this.life = life;
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

    @Override
    public String toString() {
        return name + " PA:" + attackPoints + " / PD:" + defensePoints + " / PV:" + life;
    }
    public void attack(Player p) {
        System.out.println("// ABANS DE L'ATAC:");
        System.out.println("Atacant: " + this);
        System.out.println("Atacat: " + p);

        System.out.println("// ATAC:");
        p.hit(this.attackPoints);

        if (p.life > 0) {
            this.hit(p.attackPoints);
        }

        System.out.println("// DESPRÉS DE L'ATAC:");
        System.out.println("Atacant: " + this);
        System.out.println("Atacat: " + p);
        System.out.println();
    }
    protected void hit(int attackPoints) {
        int damage = attackPoints - this.defensePoints;

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
                        " punts i es defén amb " + this.defensePoints +
                        ". Vides: " + oldLife + " - " + damage + " = " + this.life
        );
    }

}
