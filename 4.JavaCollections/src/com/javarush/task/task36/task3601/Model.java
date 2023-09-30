package com.javarush.task.task36.task3601;

import java.util.List;

/**
 * @author Denis Zolotarev
 */
public class Model {
    private final Service service = new Service();

    public List<String> getStringDataList() {
        return service.getData();
    }
}
