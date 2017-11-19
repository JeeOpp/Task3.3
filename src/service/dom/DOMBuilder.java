package service.dom;

import entity.Gem;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.apache.log4j.Logger;

/**
 * Created by DNAPC on 14.11.2017.
 */
public class DOMBuilder {
    private static final Logger log = Logger.getLogger(DOMBuilder.class);
    private Set<Gem> gemSet;
    private DocumentBuilder documentBuilder;

    public DOMBuilder(){
        gemSet = new HashSet<>();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try{
            documentBuilder = factory.newDocumentBuilder();
        }catch (ParserConfigurationException ex){
            log.error(ex);
        }
    }
    public Set<Gem> getGemSet(){
        return gemSet;
    }
    public void buildEntitySet(String xmlPath){
        Document document = null;
        try{
            document = documentBuilder.parse(xmlPath);
            Element root = document.getDocumentElement();
            NodeList gemList = root.getElementsByTagName("gem");
            for(int i=0; i<gemList.getLength();i++){
                Element gemElement = (Element)gemList.item(i);
                Gem gem = buildEntity(gemElement);
                gemSet.add(gem);
            }
        }catch (IOException ex){
            log.error(ex);
        }catch (SAXException ex){
            log.error(ex);
        }
    }
    private Gem buildEntity(Element gemElement){
        Gem gem = new Gem();
        gem.setId(gemElement.getAttribute("id"));
        gem.setKind(getElementTextContent(gemElement,"kind"));
        gem.setOrigin(getElementTextContent(gemElement,"origin"));
        String preciousness;
        if((preciousness = gemElement.getAttribute("preciousness")).isEmpty()){
            gem.setPreciousness("non-precious");
        }else {
            gem.setPreciousness(preciousness);
        }
        gem.setValue(Integer.parseInt(getElementTextContent(gemElement,"value")));

        Gem.VisualParameters visualParameters = gem.getVisualParameters();
        visualParameters.setClarity(Integer.parseInt(getElementTextContent(gemElement,"clarity")));
        visualParameters.setColour(getElementTextContent(gemElement,"colour"));
        visualParameters.setFaceCount(Integer.parseInt(getElementTextContent(gemElement,"faceCount")));
        return gem;
    }
    private String getElementTextContent(Element element, String elementName){
        NodeList nodeList = element.getElementsByTagName(elementName);
        Node node = nodeList.item(0);
        return node.getTextContent();
    }
}
