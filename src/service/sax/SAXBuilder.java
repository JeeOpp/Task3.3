package service.sax;

import java.io.IOException;
import java.util.Set;
import entity.Entity;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

/**
 * Created by DNAPC on 14.11.2017.
 */
public class SAXBuilder {
    private Set<Entity> entitySet;
    private EntityHandler entityHandler;
    private XMLReader xmlReader;

    public SAXBuilder(){
        entityHandler = new EntityHandler();
        try {
            xmlReader = XMLReaderFactory.createXMLReader();
            xmlReader.setContentHandler(entityHandler);
        }catch (SAXException ex){
            ex.printStackTrace();
        }
    }
    public Set<Entity> getEntitySet(){
        return entitySet;
    }

    public void buildEntitySet(String xmlPath){
        try{
            xmlReader.parse(xmlPath);
        }catch (SAXException ex){
            ex.printStackTrace();
        }
        catch (IOException ex){
            ex.printStackTrace();
        }
        entitySet = entityHandler.getEntities();
    }
}
