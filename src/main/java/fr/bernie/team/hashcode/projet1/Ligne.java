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
}
