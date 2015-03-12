package fr.bernie.team.hashcode.projet1.utils;

import fr.bernie.team.hashcode.projet1.Coordonnee;

import java.util.List;

/**
 * Created by Rémy on 12/03/2015.
 */
public class FileStructure {

    private int nbrangee=0, nbcoorperline=0,indispcoor=0,nbgroup=0,nbservers=0;
    private List<Coordonnee> coordonneeListIndisp;
    private List<Coordonnee> coordonneeList;

    public FileStructure(int nbrangee, int nbcoorperline, int indispcoor, int nbgroup, int nbservers, List<Coordonnee> coordonneeListIndisp, List<Coordonnee> coordonneeList) {
        this.nbrangee = nbrangee;
        this.nbcoorperline = nbcoorperline;
        this.indispcoor = indispcoor;
        this.nbgroup = nbgroup;
        this.nbservers = nbservers;
        this.coordonneeListIndisp = coordonneeListIndisp;
        this.coordonneeList = coordonneeList;
    }

    public FileStructure() {
    }

    public List<Coordonnee> getCoordonneeListIndisp() {
        return coordonneeListIndisp;
    }

    public void setCoordonneeListIndisp(List<Coordonnee> coordonneeListIndisp) {
        this.coordonneeListIndisp = coordonneeListIndisp;
    }

    public List<Coordonnee> getCoordonneeList() {
        return coordonneeList;
    }

    public void setCoordonneeList(List<Coordonnee> coordonneeList) {
        this.coordonneeList = coordonneeList;
    }

    public int getNbrangee() {
        return nbrangee;
    }

    public void setNbrangee(int nbrangee) {
        this.nbrangee = nbrangee;
    }

    public int getNbcoorperline() {
        return nbcoorperline;
    }

    public void setNbcoorperline(int nbcoorperline) {
        this.nbcoorperline = nbcoorperline;
    }

    public int getIndispcoor() {
        return indispcoor;
    }

    public void setIndispcoor(int indispcoor) {
        this.indispcoor = indispcoor;
    }

    public int getNbgroup() {
        return nbgroup;
    }

    public void setNbgroup(int nbgroup) {
        this.nbgroup = nbgroup;
    }

    public int getNbservers() {
        return nbservers;
    }

    public void setNbservers(int nbservers) {
        this.nbservers = nbservers;
    }
}
