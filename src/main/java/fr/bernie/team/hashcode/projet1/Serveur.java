package fr.bernie.team.hashcode.projet1;

/**
 * Created by bbo on 12/03/15.
 */
public class Serveur {

    int taille;
    int capacite;
    int indice;
    int groupe;


    public Serveur() {
    }

    public Serveur(int taille, int capacite, int indice) {
        this.taille = taille;
        this.capacite = capacite;
        this.indice = indice;
    }

    public int getTaille() {
        return taille;
    }

    public void setTaille(int taille) {
        this.taille = taille;
    }

    public int getCapacite() {
        return capacite;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }

    public int getGroupe() {
        return groupe;
    }

    public void setGroupe(int groupe) {
        this.groupe = groupe;
    }

    public double getDensite (){
        return (double)this.capacite / this.taille;
    }
}
