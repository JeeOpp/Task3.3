package entity;

import javax.xml.bind.annotation.*;
import java.sql.PreparedStatement;

/**
 * Created by DNAPC on 14.11.2017.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder={"kind","origin","visualParameters","value"},name = "gem")
public class Gem {
    @XmlAttribute(required = true)
    @XmlID
    private String name;
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

    public Gem(String name, String kind, String preciousness, String origin, VisualParameters visualParameters, Integer value) {
        this.name = name;
        this.kind = kind;
        this.preciousness = preciousness;
        this.origin = origin;
        this.visualParameters = visualParameters;
        this.value = value;
    }

    public String getName() {
        return name;
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

    public void setName(String name) {
        this.name = name;
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

    @Override
    public String toString() {
        return "Gem{" +
                "name='" + name + '\'' +
                ", kind='" + kind + '\'' +
                ", preciousness='" + preciousness + '\'' +
                ", origin='" + origin + '\'' +
                ", visualParameters=" + visualParameters +
                ", value=" + value +
                '}';
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
    }
}
