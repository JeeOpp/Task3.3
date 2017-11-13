package service;

import entity.Entity;
import java.util.List;

/**
 * Created by DNAPC on 08.11.2017.
 */
public interface Service {
    List<Entity> SAXParse(String xmlPath);
    List<Entity> StAXParse(String xmlPath);
    List<Entity> DOMParse(String xmlPath);
}
