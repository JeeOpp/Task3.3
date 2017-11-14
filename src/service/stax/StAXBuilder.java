package service.stax;

import entity.Entity;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.XMLEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by DNAPC on 14.11.2017.
 */
public class StAXBuilder {
    private Set<Entity> entitySet;
    private XMLInputFactory xmlInputFactory;

    public StAXBuilder(){
        entitySet = new HashSet<>();
        xmlInputFactory = XMLInputFactory.newInstance();
    }
    public Set<Entity> getEntitySet(){
        return entitySet;
    }

    public void buildEntitySet(String xmlPath) {
        try {
            XMLEventReader xmlEventReader = xmlInputFactory.createXMLEventReader(new FileInputStream(xmlPath));
            while (xmlEventReader.hasNext()){
                XMLEvent xmlEvent = xmlEventReader.nextEvent();
                if(xmlEvent.isStartElement()){

                }
                if (xmlEvent.isEndElement()){

                }
                if(xmlEvent.isCharacters()){
                    //НЕ ФАКТ ЧТО НУЖНО!!!!!
                }
            }
        }catch (XMLStreamException ex){
            ex.printStackTrace();
        }catch (FileNotFoundException ex){
            ex.printStackTrace();
        }
    }
}
