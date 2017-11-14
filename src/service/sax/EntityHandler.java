package service.sax;

import entity.Entity;
import entity.EntityEnum;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.EnumSet;
import java.util.Set;

/**
 * Created by DNAPC on 14.11.2017.
 */
public class EntityHandler extends DefaultHandler {
    private Set<Entity> students;
    private Entity current=null;
    private EntityEnum currentEnum = null;
    private EnumSet<EntityEnum> withText;

    public EntityHandler() {
        super();
    }

    @Override
    public void startElement(String s, String s1, String s2, Attributes attributes) throws SAXException {
        super.startElement(s, s1, s2, attributes);
    }

    @Override
    public void endElement(String s, String s1, String s2) throws SAXException {
        super.endElement(s, s1, s2);
    }

    @Override
    public void characters(char[] chars, int i, int i1) throws SAXException {
        super.characters(chars, i, i1);
    }
    public Set<Entity> getEntities(){
        return null;
    }
}
