package service;

import entity.Gem;
import entity.Gems;
import org.apache.log4j.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Set;

/**
 * Created by DNAPC on 18.11.2017.
 */
public class WrappedMarshaller {
    private static final Logger log = Logger.getLogger(WrappedMarshaller.class);
    private Set<Gem> gemSet = null;
    private String path = null;

    public WrappedMarshaller(){

    }
    public WrappedMarshaller(Set<Gem> gemSet, String path){
        this.gemSet = gemSet;
        this.path = path;
    }

    public void createXml() {

        try {
            JAXBContext context = JAXBContext.newInstance(Gems.class);
            Marshaller marshaller = context.createMarshaller();
            Gems gems = new Gems();
            for (Gem each : gemSet) {
                gems.add(each);
            }
            marshaller.marshal(gems, new FileOutputStream(path));
        } catch (JAXBException ex) {
            log.error(ex);
        } catch (FileNotFoundException ex){
            log.error(ex);
        }
    }
}
