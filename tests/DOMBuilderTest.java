import controller.Controller;
import entity.Gem;
import org.junit.Test;
import service.builder.DOMBuilder;

import java.util.Set;

import static junit.framework.Assert.*;

/**
 * Created by DNAPC on 19.11.2017.
 */
public class DOMBuilderTest {
    @Test
    public void buildEntityTest(){
        String xmlPath = Controller.PATH;
        DOMBuilder domBuilder = new DOMBuilder();
        domBuilder.buildEntitySet(xmlPath);
        Set<Gem> gemSet = domBuilder.getGemSet();

        Gem.VisualParameters visualParameters = new Gem.VisualParameters("yellow",86,10);
        Gem example = new Gem("a1","Yeludit","semi-precious","Kazahstan",visualParameters,12);

        Boolean expected = gemSet.contains(example);

        assertEquals(true, gemSet.contains(example));
    }
}
