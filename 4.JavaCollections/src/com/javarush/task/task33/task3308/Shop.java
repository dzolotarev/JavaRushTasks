package com.javarush.task.task33.task3308;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

/**
 * @author Denis Zolotarev
 */
@XmlType(name = "shop")
@XmlRootElement

public class Shop {
    public Goods goods;
    public int count;
    public double profit;
    public String[] secretData;

    @XmlType(name = "goods")
    @XmlRootElement
    public static class Goods {
        //       @XmlAnyElement
        //       @XmlMixed
        public List<String> names;
    }
}
