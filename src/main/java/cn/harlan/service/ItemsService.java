package cn.harlan.service;

import cn.harlan.entity.Items;

import java.util.List;

public interface ItemsService {
    public List<Items> queryListForPage();
    public int  additem(Items items);
    public Items queryItem(Items items);
    public void deleteById(Items items);
    public Items queryItemById(Items items);
    public void update(Items items);
}
