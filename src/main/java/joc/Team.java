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

    public void addPlayer(Player p) {
        if (p != null && !players.contains(p)) {
            players.add(p);
            p.addTeam(this);
        }
    }

    public void removePlayer(Player p) {
        if (p != null && players.contains(p)) {
            players.remove(p);
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

        if (!this.name.equals(other.name)) return false;
        return this.players.equals(other.players);
    }
}