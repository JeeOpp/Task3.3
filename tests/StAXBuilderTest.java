import controller.Controller;
import entity.Gem;
import entity.NaturalGem;
import org.junit.Test;
import service.builder.StAXBuilder;

import java.util.Set;

import static junit.framework.Assert.assertEquals;

/**
 * Created by DNAPC on 19.11.2017.
 */
public class StAXBuilderTest {
    @Test
    public void buildEntityTest(){
        String xmlPath = Controller.PATH;
        StAXBuilder stAXBuilder = new StAXBuilder();
        stAXBuilder.buildEntitySet(xmlPath);
        Set<Gem> gemSet = stAXBuilder.getGemSet();

        Gem.VisualParameters visualParameters = new Gem.VisualParameters("yellow",86,10);
        Gem example = new NaturalGem("a1","Yeludit","semi-precious","Kazahstan",visualParameters,12,100000);

        assertEquals(true, gemSet.contains(example));
    }
}
