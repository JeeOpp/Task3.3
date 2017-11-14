package service;

import entity.Entity;
import java.util.List;
import java.util.Set;

/**
 * Created by DNAPC on 08.11.2017.
 */
public interface Service {
    Set<Entity> parseXML(String method, String xmlPath);
}
