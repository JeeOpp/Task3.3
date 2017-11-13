package service;

import service.impl.ServiceImpl;

/**
 * Created by DNAPC on 09.11.2017.
 */
public class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();
    private final Service service = new ServiceImpl();

    private ServiceFactory() {}

    public static ServiceFactory getInstance(){
        return instance;
    }
    public Service getService(){
        return service;
    }
}
