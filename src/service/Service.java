package service;

import entity.Gem;

import java.util.Set;

/**
 * Created by DNAPC on 08.11.2017.
 */
public interface Service {
    Set<Gem> parseXML(String method, String xmlPath);
    Set<Gem> getRecords(Set<Gem> gemSet, int first, int last);
}
