import org.junit.Test;
import static junit.framework.Assert.*;
/**
 * Created by DNAPC on 19.11.2017.
 */
public class Tester {
    @Test
    public void test(){
        DOMBuilderTest domBuilderTest = new DOMBuilderTest();
        SAXBuilderTest saxBuilderTest = new SAXBuilderTest();
        StAXBuilderTest stAXBuilderTest = new StAXBuilderTest();

        domBuilderTest.buildEntityTest();
        saxBuilderTest.buildEntityTest();
        stAXBuilderTest.buildEntityTest();
    }
}
