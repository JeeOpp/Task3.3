package service.impl;

import entity.Entity;
import service.Service;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by DNAPC on 09.11.2017.
 */
public class ServiceImpl implements Service {
    @Override
    public List<Entity> SAXParse(String xmlPath) {
        return null;
    }

    @Override
    public List<Entity> StAXParse(String xmlPath) {
        return null;
    }

    @Override
    public List<Entity> DOMParse(String xmlPath) {
        return null;
    }
}
