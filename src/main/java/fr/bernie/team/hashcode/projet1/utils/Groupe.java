package fr.bernie.team.hashcode.projet1.utils;

import fr.bernie.team.hashcode.projet1.Serveur;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bbo on 12/03/15.
 */
public class Groupe {

    List<Serveur> serveurs =new ArrayList<Serveur>();

    public Groupe() {
    }

    @Override
    public String toString() {
        return "Groupe{" +
                "serveurs=" + serveurs +
                '}';
    }

    public void addServeur(Serveur ser){
        serveurs.add(ser);
    }

    public void removeServeur(Serveur ser){
        serveurs.remove(ser);
    }

    public List<Serveur> getServeurs() {
        return serveurs;
    }
}
