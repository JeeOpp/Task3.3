package service.builder;

import entity.Gem;
import entity.GemEnum;
import org.apache.log4j.Logger;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by DNAPC on 14.11.2017.
 */
public class StAXBuilder extends AbstractBuilder {
    private Gem gem = null;
    private GemEnum currentEnum = null;
    private EnumSet<GemEnum> withText = EnumSet.range(GemEnum.KIND, GemEnum.FACECOUNT);
    private XMLInputFactory xmlInputFactory;

    public StAXBuilder(){
        gemSet = new HashSet<>();
        xmlInputFactory = XMLInputFactory.newInstance();
    }

    public void buildEntitySet(String xmlPath) {
        try {
            XMLEventReader xmlEventReader = xmlInputFactory.createXMLEventReader(new FileInputStream(xmlPath));
            while (xmlEventReader.hasNext()) {
                XMLEvent xmlEvent = xmlEventReader.nextEvent();
                if (xmlEvent.isStartElement()) {
                    startElement(xmlEvent);
                }
                if(xmlEvent.isCharacters()){
                    characters(xmlEvent);
                }
                if (xmlEvent.isEndElement()) {
                    endElement(xmlEvent);
                }
            }
        } catch (XMLStreamException ex) {
            log.error(ex);
        } catch (FileNotFoundException ex) {
            log.error(ex);
        }
    }

    private void startElement(XMLEvent xmlEvent){
        StartElement startElement = xmlEvent.asStartElement();
        if (startElement.getName().getLocalPart().equals("gem")) {
            gem = new Gem();
            Attribute attr = startElement.getAttributeByName(new QName("id"));
            gem.setId(attr.getValue());
            attr = startElement.getAttributeByName(new QName("preciousness"));
            if (attr != null) {
                gem.setPreciousness(attr.getValue());
            } else {
                gem.setPreciousness("non-precious");
            }
        } else {
            GemEnum tempEnum = GemEnum.valueOf(startElement.getName().getLocalPart().toUpperCase());
            if(withText.contains(tempEnum)){
                currentEnum=tempEnum;
            }
        }
    }

    private void characters(XMLEvent xmlEvent){
        switch (currentEnum) {
            case KIND:
                gem.setKind(xmlEvent.asCharacters().getData());
                break;
            case ORIGIN:
                gem.setOrigin(xmlEvent.asCharacters().getData());
                break;
            case VALUE:
                gem.setValue(Integer.parseInt(xmlEvent.asCharacters().getData()));
                break;
            case COLOUR:
                gem.getVisualParameters().setColour(xmlEvent.asCharacters().getData());
                break;
            case CLARITY:
                gem.getVisualParameters().setClarity(Integer.parseInt(xmlEvent.asCharacters().getData()));
                break;
            case FACECOUNT:
                gem.getVisualParameters().setFaceCount(Integer.parseInt(xmlEvent.asCharacters().getData()));
                break;
            default:
                throw new EnumConstantNotPresentException(currentEnum.getDeclaringClass(), currentEnum.name());
        }
        currentEnum = null;
    }

    private void endElement(XMLEvent xmlEvent){
        EndElement endElement = xmlEvent.asEndElement();
        if (endElement.getName().getLocalPart().equals("gem")) {
            gemSet.add(gem);
        }
    }
}
