package entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;

/**
 * Created by DNAPC on 15.11.2017.
 */
//@XmlType(name = "gem")
@XmlRootElement
public class Gems {
    @XmlElement(name = "gem")
    private ArrayList<Gem> list = new ArrayList<Gem>();

    public Gems(){}

    public void setList(ArrayList<Gem> list){
        this.list=list;
    }

    public boolean add(Gem st){
        return list.add(st);
    }
}
