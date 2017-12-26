package entity;

/**
 * Created by DNAPC on 14.11.2017.
 */
public enum GemEnum {
    NATURAL_GEM ("naturalGem"),
    FAKE_GEM ("fakeGem"),
    GEMS("Gems"),
    ID("id"),
    PRECIOUSNESS("preciousness"),
    KIND("kind"),
    ORIGIN("origin"),
    VALUE("value"),
    COLOUR("colour"),
    CLARITY("clarity"),
    FACECOUNT("faceCount"),
    AGE("age"),
    SIMILARITY("similarity"),
    VISUALPARAMETERS("visualParameters");

    private String value;
    private GemEnum(String value){
        this.value=value;
    }
    public String getValue(){
        return value;
    }
}
