package service;

import entity.Gem;
import entity.GemEnum;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by DNAPC on 14.11.2017.
 */
public class EntityHandler extends DefaultHandler {
    private Set<Gem> gemSet;
    private Gem current=null;
    private GemEnum currentEnum = null;
    private EnumSet<GemEnum> withText;

    public EntityHandler() {
        gemSet = new HashSet<>();
        withText = EnumSet.range(GemEnum.KIND, GemEnum.FACECOUNT);
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if("gem".equals(localName)){
            current = new Gem();
            current.setId(attributes.getValue(0));
            if(attributes.getLength() == 2){
                current.setPreciousness(attributes.getValue(1));
            }else {
                current.setPreciousness("non-precious");  //default
            }
        }else {
            GemEnum temp = GemEnum.valueOf(localName.toUpperCase());
            if(withText.contains(temp)){
                currentEnum=temp;
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if("gem".equals(localName)){
            gemSet.add(current);
        }
    }

    @Override
    public void characters(char[] chars, int i, int i1) throws SAXException {
        String context = new String(chars, i, i1).trim();
        if(currentEnum!=null){
            switch (currentEnum){
                case KIND:
                    current.setKind(context);
                    break;
                case ORIGIN:
                    current.setOrigin(context);
                    break;
                case VALUE:
                    current.setValue(Integer.parseInt(context));
                    break;
                case COLOUR:
                    current.getVisualParameters().setColour(context);
                    break;
                case CLARITY:
                    current.getVisualParameters().setClarity(Integer.parseInt(context));
                    break;
                case FACECOUNT:
                    current.getVisualParameters().setFaceCount(Integer.parseInt(context));
                    break;
                default: throw new EnumConstantNotPresentException(currentEnum.getDeclaringClass(), currentEnum.name());
            }
            currentEnum = null;
        }
    }
    public Set<Gem> getEntities(){
        return gemSet;
    }
}
