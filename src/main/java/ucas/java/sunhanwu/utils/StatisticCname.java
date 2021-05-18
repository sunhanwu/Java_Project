package ucas.java.sunhanwu.utils;

import ucas.java.sunhanwu.cdn.AEntity;
import ucas.java.sunhanwu.cdn.CnameEntity;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;

public class StatisticCname {
    private List<CnameEntity> list;

    //constructor
    public StatisticCname(List<CnameEntity> list)
    {
        this.list = list;
    }

    // save as csv file
    public void save2csv(String path)
    {

    }

    // statistic
    public Hashtable<String, Integer> statistic() {
        Hashtable<String, Integer> statistic = new Hashtable<>();
        for(int i=0; i<this.list.size(); i++)
        {
            CnameEntity item = this.list.get(i);
            String ip = item.getArea();
            String area = IP2Area.ip2Area(ip);
            try
            {
                int temp = statistic.get(area);
                temp += 1;
                statistic.put(area, temp);
            }
            catch (Exception e)
            {
                statistic.put(area, 1);
            }
        }
        return statistic;
    }

}
