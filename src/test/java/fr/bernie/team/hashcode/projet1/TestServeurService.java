package fr.bernie.team.hashcode.projet1;

import fr.bernie.team.hashcode.projet1.utils.Groupe;
import junit.framework.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bbo on 12/03/15.
 */
public class TestServeurService {

    private ServeurService serveurService = new ServeurService();

    @Test
    public void testsortServeurByDensite() throws Exception{
        // init
        List<Serveur> ser = new ArrayList<Serveur>();
        Serveur serveur = new Serveur(3, 2, 1);
        Serveur serveur1 = new Serveur(1, 5, 2);
        ser.add(serveur);
        ser.add(serveur1);

        //exercise
        List<Serveur> res = serveurService.sortServeurByDensite(ser);

        // verify
        Assert.assertEquals(2, res.get(0).getIndice());

    }

    @Test
    public void testcreateGroupes() throws Exception{
        // init
        List<Serveur> ser = new ArrayList<Serveur>();
        Serveur serveur = new Serveur(3, 2, 1);
        Serveur serveur1 = new Serveur(1, 5, 2);
        ser.add(serveur);
        ser.add(serveur1);


        Serveur serveur2 = new Serveur(3, 2, 1);
        Serveur serveur3 = new Serveur(1, 5, 2);
        ser.add(serveur2);
        ser.add(serveur3);

        //exercise
        List<Groupe> res = serveurService.createGroupes(2, ser);

        // verify
        Assert.assertEquals(2, res.size());
        Assert.assertEquals(2, res.get(0).getServeurs().size());



    }
}
