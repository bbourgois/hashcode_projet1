package fr.bernie.team.hashcode.projet1;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by bbo on 12/03/15.
 */
public class TestLigne {

    @Test
    public void testaddServeur() throws  Exception{
        // init
        Ligne l = new Ligne(6);
        l.addContent(1, Ligne.State.INDISP);


        Serveur s = new Serveur(3, 5);

        // exercise
       int res =  l.testAddServeur(s);

        // verif
        Assert.assertEquals(2, res);


    }

}
