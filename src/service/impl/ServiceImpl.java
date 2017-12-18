package service.impl;

import entity.Gem;
import service.Service;
import service.builder.*;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by DNAPC on 09.11.2017.
 */
public class ServiceImpl implements Service {
    @Override
    public Set<Gem> parseXML(String method, String xmlPath) {
        BuilderDirector builderDirector = new BuilderDirector();
        AbstractBuilder abstractBuilder = null;

        if (method.equals("SAX")){
            abstractBuilder = new SAXBuilder();
        }
        if(method.equals("StAX")){
            abstractBuilder = new StAXBuilder();
        }
        if(method.equals("DOM")){
            abstractBuilder = new DOMBuilder();
        }

        builderDirector.setBuilder(abstractBuilder);
        builderDirector.buildGemSet(xmlPath);
        return builderDirector.getGemSet();
    }

    public Set<Gem> getRecords(Set<Gem> gemSet, int page, int recordsPerPage){
        int firstElement = (page-1)*recordsPerPage;
        int lastElement = firstElement+recordsPerPage-1;
        int i=0;
        Set<Gem> newGemSet = new HashSet<>();
        for(Gem gem:gemSet){
            if (i>=firstElement){
                newGemSet.add(gem);
            }
            if (i==lastElement){
                return newGemSet;
            }
            i++;
        }
        return newGemSet;
    }
}
