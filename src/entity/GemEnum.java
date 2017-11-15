package entity;

/**
 * Created by DNAPC on 14.11.2017.
 */
public enum GemEnum {
    GEMS("gems"),
    NAME("name"),
    PRECIOUSNESS("preciousness"),
    ORIGIN("origin"),
    VALUE("value"),
    COLOUR("colour"),
    CLARITY("clarity"),
    FACECOUNT("faceCount"),
    VISUALPARAMETERS("visualParameters");

    private String value;
    private GemEnum(String value){
        this.value=value;
    }
    private String getValue(){
        return value;
    }
}
