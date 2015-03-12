package fr.bernie.team.hashcode.projet1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by bbo on 12/03/15.
 */
public class ServeurService {



    List<Serveur> sortServeurByDensite(List<Serveur> serveurs){
        List<Serveur> res  = new ArrayList<Serveur>(serveurs);
        Collections.sort(res, new Comparator<Serveur>() {
            @Override
            public int compare(Serveur serveur, Serveur t1) {
                return Double.compare(t1.getDensite(), serveur.getDensite());
            }
        });
        return res;
    }
}
