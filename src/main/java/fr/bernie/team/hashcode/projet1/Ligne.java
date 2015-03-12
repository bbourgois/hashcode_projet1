package fr.bernie.team.hashcode.projet1;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Rémy on 12/03/2015.
 */
public class Ligne {

    private int size;
    private String[] content;

    public Ligne(int size) {
        this.size = size;
        content = new String[size];
        for(int i=0;i<size;i++){
            content[i] = "e";
        }
    }

    public void addContent(int index,String content){
        if(this.getContent()[index] !=null){
            this.getContent()[index] = content;
        }
    }

    public void removeContent(int index,String content){
        if(this.getContent()[index] !=null){
            this.getContent()[index] = "e";
        }
    }

    public String[] getContent() {
        return content;
    }


    @Override
    public String toString() {
        return "Ligne{" +
                "size=" + size +
                ", content=" + Arrays.toString(content) +
                '}';
    }

    public void setContent(String[] content) {
        this.content = content;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
