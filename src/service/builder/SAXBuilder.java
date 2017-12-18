package service.builder;

import java.io.IOException;
import java.util.Set;
import entity.Gem;
import org.apache.log4j.Logger;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import service.EntityHandler;

/**
 * Created by DNAPC on 14.11.2017.
 */
public class SAXBuilder extends AbstractBuilder{
    private EntityHandler entityHandler;
    private XMLReader xmlReader;

    public SAXBuilder(){
        entityHandler = new EntityHandler();
        try {
            xmlReader = XMLReaderFactory.createXMLReader();
            xmlReader.setContentHandler(entityHandler);
        }catch (SAXException ex){
            log.error(ex);
        }
    }

    public void buildEntitySet(String xmlPath){
        try{
            xmlReader.parse(xmlPath);
        }catch (SAXException ex){
            log.error(ex);
        }
        catch (IOException ex){
            log.error(ex);
        }
        gemSet = entityHandler.getEntities();
    }
}
