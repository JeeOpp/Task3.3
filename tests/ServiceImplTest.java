import entity.Gem;
import entity.NaturalGem;
import org.junit.Test;
import service.ServiceFactory;
import service.builder.BuilderDirector;
import service.builder.SAXBuilder;

import java.util.Set;

import static org.junit.Assert.*;

/**
 * Created by DNAPC on 20.12.2017.
 */
public class ServiceImplTest {
    private static final String PATH = "D:\\Documents\\Java\\WEB\\Task3.3\\Task3.3\\resources\\test.xml";
    @Test
    public void getRecords() throws Exception {
        BuilderDirector builderDirector = new BuilderDirector();
        builderDirector.setBuilder(new SAXBuilder());
        builderDirector.buildGemSet(PATH);
        Set<Gem> gemSet = builderDirector.getGemSet();

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        Set<Gem> newSetGem = serviceFactory.getService().getRecords(gemSet,1,1);

        assertEquals("Yashma",newSetGem.iterator().next().getKind());
    }

}