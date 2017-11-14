package service.impl;

import entity.Entity;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import service.Service;
import service.dom.DOMBuilder;
import service.sax.EntityHandler;
import service.sax.SAXBuilder;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;

/**
 * Created by DNAPC on 09.11.2017.
 */
public class ServiceImpl implements Service {
    @Override
    public Set<Entity> parseXML(String method, String xmlPath) {
        if (method.equals("SAX")){
            return SAXParse(xmlPath);
        }
        if(method.equals("StAX")){
            return StAXParse(xmlPath);
        }
        if(method.equals("DOM")){
            return DOMParse(xmlPath);
        }
        return null;
    }

    private Set<Entity> SAXParse(String xmlPath) {
        SAXBuilder builder = new SAXBuilder();
        builder.buildEntitySet(xmlPath);
        return builder.getEntitySet();
    }

    private Set<Entity> StAXParse(String xmlPath) {
        return null;
    }

    private Set<Entity> DOMParse(String xmlPath) {
        DOMBuilder builder = new DOMBuilder();
        builder.buildEntitySet(xmlPath);
        return builder.getEntitySet();
    }
}
