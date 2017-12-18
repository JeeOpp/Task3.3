package service.builder;

import entity.Gem;
import org.apache.log4j.Logger;

import java.util.Set;

/**
 * Created by DNAPC on 19.12.2017.
 */
public abstract class AbstractBuilder {
    protected static final Logger log = Logger.getLogger(DOMBuilder.class);
    protected Set<Gem> gemSet;

    public Set<Gem> getGemSet(){
        return gemSet;
    }

    public abstract void buildEntitySet(String xmlPath);
}
