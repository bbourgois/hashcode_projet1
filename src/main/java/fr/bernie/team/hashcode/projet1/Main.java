package fr.bernie.team.hashcode.projet1;

import fr.bernie.team.hashcode.projet1.utils.FileReaderUtil;
import fr.bernie.team.hashcode.projet1.utils.FileStructure;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by bbo on 12/03/15.
 */
public class Main {

    private static final Logger log = LoggerFactory.getLogger(Data.class);





    public static void main(String[] args) {
        log.info("test Data");
        FileReaderUtil fileReaderUtil = new FileReaderUtil("C:\\Users\\Rémy\\Desktop\\entryFile.txt");
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
        for(Coordonnee coordonnee : fileStructure.getCoordonneeList()){

            coorOk = coorOk.concat("[").concat(String.valueOf(coordonnee.getEmplacement())).concat(",").concat(String.valueOf(coordonnee.getRangee())).concat("]").concat("\n");
        }
        log.warn("Okay :"+coorOk);


        Data data = new Data();
        data.setNbRangee(fileStructure.getNbrangee());
        data.setNbEmplacement(fileStructure.getNbcoorperline());
        data.setIndisponibles(fileStructure.getCoordonneeListIndisp());

        //data setserveurs ?

    }
}
