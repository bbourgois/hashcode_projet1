package fr.bernie.team.hashcode.projet1;

import fr.bernie.team.hashcode.projet1.utils.Groupe;

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

    List<Groupe> createGroupes(int nbGroupe, List<Serveur> serveurs){

        List<Groupe> grps = new ArrayList<Groupe>(nbGroupe);
        for (int i=0;  i < nbGroupe; i ++){
            grps.add(new Groupe());
        }

        int temp = 0;
        boolean up = true;
        for(Serveur serv :serveurs){
            Groupe grp = grps.get(temp);
            grp.addServeur(serv);
            if (up){
                temp ++;
            }else{
                temp --;
            }

            if (temp == nbGroupe){
                up = false;
                temp --;
            }
            if (temp < 0){
                up = true;
                temp = 0;
            }

        }
        return  grps;

    }


}
