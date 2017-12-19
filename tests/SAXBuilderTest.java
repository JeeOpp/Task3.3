import controller.Controller;
import entity.Gem;
import entity.NaturalGem;
import org.junit.Test;
import service.builder.SAXBuilder;

import java.util.Set;

import static junit.framework.Assert.assertEquals;

/**
 * Created by DNAPC on 19.11.2017.
 */
public class SAXBuilderTest {
    @Test
    public void buildEntityTest(){
        String xmlPath = Controller.PATH;
        SAXBuilder saxBuilder = new SAXBuilder();
        saxBuilder.buildEntitySet(xmlPath);
        Set<Gem> gemSet = saxBuilder.getGemSet();

        Gem.VisualParameters visualParameters = new Gem.VisualParameters("yellow",86,10);
        Gem example = new NaturalGem("a1","Yeludit","semi-precious","Kazahstan",visualParameters,12,100000);

        assertEquals(true, gemSet.contains(example));
    }
}
