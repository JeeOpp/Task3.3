package service.dom;

import entity.Entity;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * Created by DNAPC on 14.11.2017.
 */
public class DOMBuilder {
    private Set<Entity> entitySet;
    private DocumentBuilder documentBuilder;

    public DOMBuilder(){
        entitySet = new HashSet<>();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try{
            documentBuilder = factory.newDocumentBuilder();
        }catch (ParserConfigurationException ex){
            ex.printStackTrace();
        }
    }
    public Set<Entity> getEntitySet(){
        return entitySet;
    }
    public void buildEntitySet(String xmlPath){
        Document document = null;
        try{
            document = documentBuilder.parse(xmlPath);
            Element root = document.getDocumentElement();
            NodeList entityList = root.getElementsByTagName("entity");
            for(int i=0; i<entityList.getLength();i++){
                Element entityElement = (Element)entityList.item(i);
                Entity entity = buildEntity(entityElement);
                entitySet.add(entity);
            }
        }catch (IOException ex){
            ex.printStackTrace();
        }catch (SAXException ex){
            ex.printStackTrace();
        }
    }
    private Entity buildEntity(Element entityElement){

    }
    private /*static*/ String getElementTextContent(Element element, String elementName){
        return text;
    }
}
