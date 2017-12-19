package entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by DNAPC on 19.12.2017.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder={"age"},name = "naturalGem")
public class NaturalGem extends Gem {
    private int age;

    public NaturalGem() {
    }

    public NaturalGem(String id, String kind, String preciousness, String origin, VisualParameters visualParameters, Integer value, int age) {
        super(id, kind, preciousness, origin, visualParameters, value);
        this.age = age;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NaturalGem)) return false;
        if (!super.equals(o)) return false;

        NaturalGem that = (NaturalGem) o;

        return getAge() == that.getAge();
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + getAge();
        return result;
    }
}
