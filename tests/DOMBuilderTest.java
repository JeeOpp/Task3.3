import entity.Gem;
import org.junit.Test;
import service.dom.DOMBuilder;

import java.util.Set;

import static junit.framework.Assert.*;

/**
 * Created by DNAPC on 19.11.2017.
 */
public class DOMBuilderTest {
    @Test
    public void buildEntityTest(){
        String xmlPath = "D:\\Documents\\Java\\WEB\\Task3.3\\Task3.3\\resources\\test.xml";
        DOMBuilder domBuilder = new DOMBuilder();
        domBuilder.buildEntitySet(xmlPath);
        Set<Gem> gemSet = domBuilder.getGemSet();

        Gem.VisualParameters visualParameters = new Gem.VisualParameters("yellow",86,10);
        Gem example = new Gem("a1","Yeludit","semi-precious","Kazahstan",visualParameters,12);

        Boolean expected = gemSet.contains(example);

        assertEquals(true, gemSet.contains(example));
    }
}
