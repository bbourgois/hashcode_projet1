package fr.bernie.team.hashcode.projet1;

/**
 * Created by bbo on 12/03/15.
 */
public class Coordonnee {

    int rangee;
    int emplacement;

    public Coordonnee() {
    }

    public Coordonnee(int rangee, int emplacement) {
        this.rangee = rangee;
        this.emplacement = emplacement;
    }

    public int getEmplacement() {
        return emplacement;
    }

    public void setEmplacement(int emplacement) {
        this.emplacement = emplacement;
    }

    public int getRangee() {
        return rangee;
    }

    public void setRangee(int rangee) {
        this.rangee = rangee;
    }
}
