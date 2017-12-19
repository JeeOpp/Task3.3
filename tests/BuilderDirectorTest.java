import org.junit.Test;
import service.builder.BuilderDirector;
import service.builder.SAXBuilder;

import static org.junit.Assert.*;

/**
 * Created by DNAPC on 20.12.2017.
 */
public class BuilderDirectorTest {
    private static final String PATH = "D:\\Documents\\Java\\WEB\\Task3.3\\Task3.3\\resources\\test.xml";

    @Test
    public void setBuilder() throws Exception {
        BuilderDirector builderDirector = new BuilderDirector();
        builderDirector.setBuilder(new SAXBuilder());
        assertEquals (true,builderDirector.getAbstractBuilder() instanceof SAXBuilder);
    }

    @Test
    public void getGemSet() throws Exception {
        BuilderDirector builderDirector = new BuilderDirector();
        builderDirector.setBuilder(new SAXBuilder());
        builderDirector.buildGemSet(PATH);

        assertEquals(false,builderDirector.getGemSet().isEmpty());
    }
}