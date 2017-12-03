package cn.harlan.impl;

import cn.harlan.dao.ItemsMapper;
import cn.harlan.entity.Items;
import cn.harlan.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemsServiceImpl implements ItemsService {
    @Autowired
    ItemsMapper mapper;

    @Override
    public List<Items> queryListForPage() {
        return mapper.queryListForPage();
    }

    @Override
    public int additem(Items items) {
        return mapper.additem(items);
    }

    @Override
    public Items queryItem(Items items) {
        return mapper.queryItem(items);
    }

    @Override
    public void deleteById(Items items) {
        mapper.deleteById(items);
    }

    @Override
    public Items queryItemById(Items items) {
        return mapper.queryItemById(items);
    }

    @Override
    public void update(Items items) {
        mapper.update(items);
    }
}
