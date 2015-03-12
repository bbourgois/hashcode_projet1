package fr.bernie.team.hashcode.projet1.utils;

import fr.bernie.team.hashcode.projet1.Coordonnee;
import fr.bernie.team.hashcode.projet1.Data;
import fr.bernie.team.hashcode.projet1.Serveur;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rémy on 12/03/2015.
 */
public class FileReaderUtil {
    private String path;

    public FileReaderUtil(String path) {
        this.path = path;
    }

    private static final Logger log = LoggerFactory.getLogger(FileReaderUtil.class);

    public FileStructure readFile(){
        BufferedReader br = null;
        int lineread = 0;

        FileStructure fileStructure = new FileStructure();

        int nbrangee=0, nbcoorperline=0,indispcoor=0,nbgroup=0,nbservers=0;
        List<Coordonnee> indispoList = new ArrayList<Coordonnee>();
        List<Serveur> serverList = new ArrayList<Serveur>();

        try {

            String sCurrentLine;

            br = new BufferedReader(new FileReader(path));


            while ((sCurrentLine = br.readLine()) != null) {

                if(lineread == 0){
                    String []values = sCurrentLine.split(" ");
                    try{
                        nbrangee = Integer.parseInt(values[0]);
                        fileStructure.setNbrangee(nbrangee);
                        nbcoorperline = Integer.parseInt(values[1]);
                        fileStructure.setNbcoorperline(nbcoorperline);
                        indispcoor = Integer.parseInt(values[2]);
                        fileStructure.setIndispcoor(indispcoor);
                        nbgroup = Integer.parseInt(values[3]);
                        fileStructure.setNbgroup(nbgroup);
                        nbservers = Integer.parseInt(values[4]);
                        fileStructure.setNbservers(nbservers);
                    }
                    catch (NumberFormatException e){
                        log.error("Malformed file",e);
                    }
                    lineread++;
                }
                else if(lineread < indispcoor+1 && lineread > 0){
                    String[] coor = sCurrentLine.split(" ");
                    log.warn("indisp "+coor[0]+" "+coor[1]);
                    indispoList.add(new Coordonnee(Integer.parseInt(coor[0]), Integer.parseInt(coor[1])));
                    lineread++;
                }
                else{
                    String[] coorOk = sCurrentLine.split(" ");
                    serverList.add(new Serveur(Integer.parseInt(coorOk[0]), Integer.parseInt(coorOk[1])));
                    lineread++;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)br.close();
                fileStructure.setCoordonneeListIndisp(indispoList);
                fileStructure.setCoordonneeList(serverList);
                return fileStructure;

            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return fileStructure;
    }
}
