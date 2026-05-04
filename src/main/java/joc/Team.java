package joc;

import java.util.ArrayList;

public class Team {

    private String name;
    private ArrayList<Player> players;

    public Team(String name) {
        this.name = name;
        this.players = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void addPlayer(Player p) throws JocException {
        if (p == null) {
            throw new JocException("El jugador no existeix.");
        }

        if (players.contains(p)) {
            throw new JocException("L'equip no pot tindre jugadors repetits.");
        }

        players.add(p);

        if (!p.getTeams().contains(this)) {
            p.addTeam(this);
        }
    }

    public void removePlayer(Player p) throws JocException {
        if (p == null) {
            throw new JocException("El jugador no existeix.");
        }

        if (!players.contains(p)) {
            throw new JocException("No podem llevar d'un equip a un jugador que no li pertany.");
        }

        players.remove(p);

        if (p.getTeams().contains(this)) {
            p.removeTeam(this);
        }
    }

    @Override
    public String toString() {
        String text = "Equip " + name + ":\n";

        for (Player p : players) {
            text += p + "\n";
        }

        return text;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Team)) return false;

        Team other = (Team) obj;

        return this.name.equalsIgnoreCase(other.name);
    }
}