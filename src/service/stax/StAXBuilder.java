package service.stax;

import entity.Gem;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.XMLEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by DNAPC on 14.11.2017.
 */
public class StAXBuilder {
    private Set<Gem> gemSet;
    private XMLInputFactory xmlInputFactory;

    public StAXBuilder(){
        gemSet = new HashSet<>();
        xmlInputFactory = XMLInputFactory.newInstance();
    }
    public Set<Gem> getGemSet(){
        return gemSet;
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
