package service;

import entity.FakeGem;
import entity.Gem;
import entity.GemEnum;
import entity.NaturalGem;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

import static entity.GemEnum.FAKE_GEM;
import static entity.GemEnum.NATURAL_GEM;

/**
 * Created by DNAPC on 14.11.2017.
 */
public class EntityHandler extends DefaultHandler {
    private Set<Gem> gemSet;
    private Gem current=null;
    private GemEnum currentEnum = null;
    private EnumSet<GemEnum> withText;

    public final int FIRST_ATTRIBUTE = 0;
    public final int SECOND_ATTRIBUTE = 1;
    public final int MAX_COUNT_ATTRIBUTES = 2;

    public final String DEFAULT_PRECIOUS = "non-precious";


    public EntityHandler() {
        gemSet = new HashSet<>();
        withText = EnumSet.range(GemEnum.KIND, GemEnum.SIMILARITY);
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (NATURAL_GEM.getValue().equals(localName) || FAKE_GEM.getValue().equals(localName)) {
            current = localName.equals(NATURAL_GEM.getValue()) ? new NaturalGem(): new FakeGem();
            current.setId(attributes.getValue(FIRST_ATTRIBUTE));
            if (attributes.getLength() == MAX_COUNT_ATTRIBUTES) {
                current.setPreciousness(attributes.getValue(SECOND_ATTRIBUTE));
            } else {
                current.setPreciousness(DEFAULT_PRECIOUS);
            }
        } else {
            GemEnum temp = GemEnum.valueOf(localName.toUpperCase());
            if(withText.contains(temp)){
                currentEnum=temp;
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if(NATURAL_GEM.getValue().equals(localName) || FAKE_GEM.getValue().equals(localName)){
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
                case AGE:
                    current.setAge(Integer.parseInt(context));
                    break;
                case SIMILARITY:
                    current.setSimilarity(Integer.parseInt(context));
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
