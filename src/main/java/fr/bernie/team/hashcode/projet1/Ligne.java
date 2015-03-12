package fr.bernie.team.hashcode.projet1;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Rémy on 12/03/2015.
 */
public class Ligne {

    private int size;
    private State[] content;

    public enum State {
        EMPTY,
        INDISP,
        FULL
    }

    private State state;

    public Ligne(int size) {
        this.size = size;
        content = new State[size];
        for(int i=0;i<size;i++){
            content[i] = State.EMPTY ;
        }
    }

    public void addContent(int index,State content){
        if(this.getContent()[index] !=null){
            this.getContent()[index] = content;
        }
    }

    public void removeContent(int index,State content){
        if(this.getContent()[index] !=null){
            this.getContent()[index] = State.EMPTY;
        }
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public State[] getContent() {
        return content;
    }

    public void setContent(State[] content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Ligne{" +
                "size=" + size +
                ", content=" + Arrays.toString(content) +
                '}';
    }


    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    int testAddServeur(Serveur ser){
        int emplacement = -1;

        int taille = ser.getTaille();
        int temp = taille;
        int emplacementTest = 0;
        int pos = 0;
        for (State s : content) {
            pos++;
            if (State.EMPTY.equals(s)) {
                temp --;

            }else{
                temp = taille;
                emplacementTest = pos;
            }
            if (temp == 0){
                emplacement = emplacementTest;

                break;
            }
        }

        return emplacement;

    }

    int addServeur(Serveur ser){
        int pos = testAddServeur(ser);
        if (pos >= 0){
            // reservation
            for (int i = pos; i <(pos + ser.getTaille()) ;i ++  ){
                content[i] = State.FULL;
            }
        }
        return pos;
    }
}
