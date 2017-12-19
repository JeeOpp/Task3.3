package entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by DNAPC on 19.12.2017.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder={"similarity"},name = "fakeGem")
public class FakeGem extends Gem {
    @XmlElement(required = true)
    private int similarity;

    public FakeGem() {
    }

    public FakeGem(String id, String kind, String preciousness, String origin, VisualParameters visualParameters, Integer value, int similarity) {
        super(id, kind, preciousness, origin, visualParameters, value);
        this.similarity = similarity;
    }

    public Integer getSimilarity() {
        return similarity;
    }

    public void setSimilarity(int similarity) {
        this.similarity = similarity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FakeGem)) return false;
        if (!super.equals(o)) return false;

        FakeGem fakeGem = (FakeGem) o;

        return getSimilarity() == fakeGem.getSimilarity();
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + getSimilarity();
        return result;
    }
}
