package service.builder;

import entity.Gem;

import java.util.Set;

/**
 * Created by DNAPC on 19.12.2017.
 */
public class BuilderDirector {
    private AbstractBuilder abstractBuilder;

    public void setBuilder(AbstractBuilder abstractBuilder) { this.abstractBuilder = abstractBuilder; }

    public void buildGemSet(String xmlPath) {
        abstractBuilder.buildEntitySet(xmlPath);
    }

    public Set<Gem> getGemSet() { return abstractBuilder.getGemSet(); }
    public AbstractBuilder getAbstractBuilder(){
        return abstractBuilder;
    }
}
