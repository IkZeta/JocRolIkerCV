package joc;

public class Alien extends Player {

    public Alien(String name, int attackPoints, int defensePoints, int life) {
        super(name, attackPoints, defensePoints, life);
    }
    @Override
    public void attack(Player p) throws JocException {
        if (getLife() > 20) {
            setAttackPoints(getAttackPoints() + 3);
            setDefensePoints(getDefensePoints() - 3);
        }

        super.attack(p);
    }
}