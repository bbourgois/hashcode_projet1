package fr.bernie.team.hashcode.projet1;

import fr.bernie.team.hashcode.projet1.utils.FileReaderUtil;
import fr.bernie.team.hashcode.projet1.utils.FileStructure;
import fr.bernie.team.hashcode.projet1.utils.Groupe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bbo on 12/03/15.
 */
public class Main {

    private static final Logger log = LoggerFactory.getLogger(Data.class);


    public static void main(String[] args) {
        ServeurService serveurService = new ServeurService();

        log.info("test Data");
        FileReaderUtil fileReaderUtil = new FileReaderUtil("entryFile2.txt");
        FileStructure fileStructure = fileReaderUtil.readFile();
        log.warn("Structure : " +
                "nb ranges " + fileStructure.getNbrangee()+
                "nb emp per line : "+fileStructure.getNbcoorperline()+
                        "indisp emp : "+ fileStructure.getIndispcoor()+
                        "grp : " +fileStructure.getNbgroup()+
                        "servers : " + fileStructure.getNbservers()
                    );

        String coorIndisp ="";
        for(Coordonnee coordonnee : fileStructure.getCoordonneeListIndisp()){

            coorIndisp = coorIndisp.concat("[").concat(String.valueOf(coordonnee.getEmplacement())).concat(",").concat(String.valueOf(coordonnee.getRangee())).concat("]").concat("\n");
        }
        log.warn("Indispo :"+coorIndisp);

        String coorOk ="";
        for(Serveur coordonnee : fileStructure.getCoordonneeList()){

            coorOk = coorOk.concat("[").concat(String.valueOf(coordonnee.getTaille())).concat(",").concat(String.valueOf(coordonnee.getCapacite())).concat("]").concat("\n");
        }
        log.warn("Okay :"+coorOk);


        Data data = new Data();
        data.setNbRangee(fileStructure.getNbrangee());
        data.setNbEmplacement(fileStructure.getNbcoorperline());
        data.setIndisponibles(fileStructure.getCoordonneeListIndisp());

        List<Serveur> serveurList = new ArrayList<Serveur>();
        for(Serveur coordonnee : fileStructure.getCoordonneeList()){
            serveurList.add(new Serveur(coordonnee.getTaille(),coordonnee.getCapacite()));
        }

        //data setserveurs ?

        List<Serveur> sortedServer = serveurService.sortServeurByDensite(serveurList);

        log.warn(sortedServer.toString());

        List<Groupe> groupeList = serveurService.createGroupes(fileStructure.getNbgroup(),sortedServer);

        log.warn(groupeList.toString());

        List<Ligne> ligneList = new ArrayList<Ligne>();

        for(int i=0;i<fileStructure.getNbrangee();i++){
            Ligne ligne = new Ligne(fileStructure.getNbcoorperline());
            for(int j=0;j<ligne.getSize();j++){
                for(Coordonnee coordonnee : fileStructure.getCoordonneeListIndisp()){
                    if(coordonnee.getRangee() == i && coordonnee.getEmplacement()==j){
                        ligne.addContent(j, Ligne.State.INDISP);
                    }
                }
            }
            ligneList.add(ligne);
        }

        int grpInd = 0;
        int ligne = 0;
        int nbLigneTest = 0;
        for(Groupe grp : groupeList){
            grpInd ++;
            log.warn("groupe " + grpInd);


            for (Serveur serv : grp.getServeurs()) {
                if (ligne >= data.getNbRangee()) {
                    ligne = 0;
                }
                nbLigneTest++;
                int test = ligneList.get(ligne).addServeur(serv);
                if (test >= 0) {
                    nbLigneTest = 0;
                    ligne++;

                    continue;
                } else {
                    ligne++;

                    if (nbLigneTest > data.getNbRangee()) {
                        log.warn("perdu ");
                        break;
                    }
                }
            }
        }

        log.warn("Lignessssss : "+ligneList);
        log.warn("Lignessssss size: "+ligneList.size());
        for(Ligne lig : ligneList){
            log.warn("Ligne: "+lig);
        }


    }
}
