package service.impl;

import entity.Gem;
import service.Service;
import service.dom.DOMBuilder;
import service.sax.SAXBuilder;
import service.stax.StAXBuilder;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by DNAPC on 09.11.2017.
 */
public class ServiceImpl implements Service {
    @Override
    public Set<Gem> parseXML(String method, String xmlPath) {
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

    public static Set<Gem> getRecords(Set<Gem> gemSet, int first, int last){
        int i=0;
        Set<Gem> newGemSet = new HashSet<>();
        Gem gem;
        Iterator<Gem> iterator = gemSet.iterator();
        while (iterator.hasNext()){
            gem = iterator.next();
            if (i>=first){
                newGemSet.add(gem);
            }
            if (i==last){
                return newGemSet;
            }
            i++;
        }
        return newGemSet;
    }

    private Set<Gem> SAXParse(String xmlPath) {
        SAXBuilder builder = new SAXBuilder();
        builder.buildEntitySet(xmlPath);
        return builder.getGemSet();
    }

    private Set<Gem> StAXParse(String xmlPath) {
        StAXBuilder builder = new StAXBuilder();
        builder.buildEntitySet(xmlPath);
        return builder.getGemSet();
    }

    private Set<Gem> DOMParse(String xmlPath) {
        DOMBuilder builder = new DOMBuilder();
        builder.buildEntitySet(xmlPath);
        return builder.getGemSet();
    }
}
