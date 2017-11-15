package entity;

import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;

/**
 * Created by DNAPC on 15.11.2017.
 */
public class Gems {
    private ArrayList<Gem> list = new ArrayList<Gem>();

    public Gems(){}

    public void setList(ArrayList<Gem> list){
        this.list=list;
    }

    public boolean add(Gem st){
        return list.add(st);
    }
}
