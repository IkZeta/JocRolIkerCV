package joc;

public class Warrior extends Human {

    public Warrior(String name, int attackPoints, int defensePoints, int life) {
        super(name, attackPoints, defensePoints, life);
    }
    @Override
    protected void hit(int attackPoints) {
        int damage = attackPoints - getDefensePoints();

        if (damage <= 5) {
            damage = 0;
        }

        int oldLife = getLife();
        setLife(oldLife - damage);

        System.out.println(
                getName() + " és colpejat amb " + attackPoints +
                        " punts i es defén amb " + getDefensePoints() +
                        ". Vides: " + oldLife + " - " + damage + " = " + getLife()
        );
    }
}