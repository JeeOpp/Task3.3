package entity;

import javax.xml.bind.annotation.*;
import java.sql.PreparedStatement;

/**
 * Created by DNAPC on 14.11.2017.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder={"kind","origin","visualParameters","value"},name = "gem")
abstract public class Gem {
    @XmlAttribute(required = true)
    @XmlID
    private String id;
    @XmlElement(required = true)
    private String kind;
    @XmlAttribute(required = false)
    private String preciousness;
    @XmlElement(required = true)
    private String origin;
    private VisualParameters visualParameters = new VisualParameters();
    @XmlElement(required = true)
    private Integer value;

    public Gem(){}

    public Gem(String id, String kind, String preciousness, String origin, VisualParameters visualParameters, Integer value) {
        this.id = id;
        this.kind = kind;
        this.preciousness = preciousness;
        this.origin = origin;
        this.visualParameters = visualParameters;
        this.value = value;
    }

    public String getId() {
        return id;
    }

    public String getKind() {
        return kind;
    }

    public String getPreciousness() {
        return preciousness;
    }

    public String getOrigin() {
        return origin;
    }

    public VisualParameters getVisualParameters() {
        return visualParameters;
    }

    public Integer getValue() {
        return value;
    }

    public Integer getAge(){
        return null;
    }

    public Integer getSimilarity(){
        return null;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public void setPreciousness(String preciousness) {
        this.preciousness = preciousness;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public void setVisualParameters(VisualParameters visualParameters) {
        this.visualParameters = visualParameters;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public void setAge(int age){
    }
    public void setSimilarity(int similarity){
    }

    @Override
    public String toString() {
        return "Gem{" +
                "id='" + id + '\'' +
                ", kind='" + kind + '\'' +
                ", preciousness='" + preciousness + '\'' +
                ", origin='" + origin + '\'' +
                ", visualParameters=" + visualParameters +
                ", value=" + value +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Gem)) return false;

        Gem gem = (Gem) o;

        if (getId() != null ? !getId().equals(gem.getId()) : gem.getId() != null) return false;
        if (getKind() != null ? !getKind().equals(gem.getKind()) : gem.getKind() != null) return false;
        if (getPreciousness() != null ? !getPreciousness().equals(gem.getPreciousness()) : gem.getPreciousness() != null)
            return false;
        if (getOrigin() != null ? !getOrigin().equals(gem.getOrigin()) : gem.getOrigin() != null) return false;
        if (getVisualParameters() != null ? !getVisualParameters().equals(gem.getVisualParameters()) : gem.getVisualParameters() != null)
            return false;
        return getValue() != null ? getValue().equals(gem.getValue()) : gem.getValue() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getKind() != null ? getKind().hashCode() : 0);
        result = 31 * result + (getPreciousness() != null ? getPreciousness().hashCode() : 0);
        result = 31 * result + (getOrigin() != null ? getOrigin().hashCode() : 0);
        result = 31 * result + (getVisualParameters() != null ? getVisualParameters().hashCode() : 0);
        result = 31 * result + (getValue() != null ? getValue().hashCode() : 0);
        return result;
    }

    @XmlType(propOrder={"clarity","colour","faceCount"}, name = "visualParameters")
    public static class VisualParameters{
        private String colour;
        private Integer clarity;
        private Integer faceCount;

        public VisualParameters() {
        }

        public VisualParameters(String colour, Integer clarity, Integer faceCount) {
            this.colour = colour;
            this.clarity = clarity;
            this.faceCount = faceCount;
        }

        public String getColour() {
            return colour;
        }

        public Integer getClarity() {
            return clarity;
        }

        public Integer getFaceCount() {
            return faceCount;
        }

        public void setColour(String colour) {
            this.colour = colour;
        }

        public void setClarity(Integer clarity) {
            this.clarity = clarity;
        }

        public void setFaceCount(Integer faceCount) {
            this.faceCount = faceCount;
        }

        @Override
        public String toString() {
            return "VisualParameters{" +
                    "colour='" + colour + '\'' +
                    ", clarity=" + clarity +
                    ", faceCount=" + faceCount +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof VisualParameters)) return false;

            VisualParameters that = (VisualParameters) o;

            if (getColour() != null ? !getColour().equals(that.getColour()) : that.getColour() != null) return false;
            if (getClarity() != null ? !getClarity().equals(that.getClarity()) : that.getClarity() != null)
                return false;
            return getFaceCount() != null ? getFaceCount().equals(that.getFaceCount()) : that.getFaceCount() == null;
        }

        @Override
        public int hashCode() {
            int result = getColour() != null ? getColour().hashCode() : 0;
            result = 31 * result + (getClarity() != null ? getClarity().hashCode() : 0);
            result = 31 * result + (getFaceCount() != null ? getFaceCount().hashCode() : 0);
            return result;
        }
    }
}
