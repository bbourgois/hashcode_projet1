package fr.bernie.team.hashcode.projet1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by bbo on 09/03/15.
 */
public class Data {



    int nbRangee;
    int nbEmplacement;
    List<Coordonnee> indisponibles;
    List<Serveur> serveurs;

    public Data() {
    }

    public int getNbRangee() {
        return nbRangee;
    }

    public void setNbRangee(int nbRangee) {
        this.nbRangee = nbRangee;
    }

    public int getNbEmplacement() {
        return nbEmplacement;
    }

    public void setNbEmplacement(int nbEmplacement) {
        this.nbEmplacement = nbEmplacement;
    }

    public List<Coordonnee> getIndisponibles() {
        return indisponibles;
    }

    public void setIndisponibles(List<Coordonnee> indisponibles) {
        this.indisponibles = indisponibles;
    }

    public List<Serveur> getServeurs() {
        return serveurs;
    }

    public void setServeurs(List<Serveur> serveurs) {
        this.serveurs = serveurs;
    }
}
