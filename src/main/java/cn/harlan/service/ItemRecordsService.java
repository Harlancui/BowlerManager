package cn.harlan.service;

import cn.harlan.entity.ItemMap;
import cn.harlan.entity.ItemRecords;

import java.util.List;

public interface ItemRecordsService {

    List<ItemRecords> queryRuKu(Integer type);

    List<ItemMap> queryMap();
    Integer queryPrice(Integer id);
    Integer putinadd(ItemRecords itemRecords);
    public  void kucunadd(ItemRecords itemRecords);
    public  void chukuadd(ItemRecords itemRecords);
    Integer checknumber(Integer id);
}
