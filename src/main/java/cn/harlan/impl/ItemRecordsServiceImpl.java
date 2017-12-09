package cn.harlan.impl;

import cn.harlan.dao.ItemRecordsMapper;
import cn.harlan.entity.ItemMap;
import cn.harlan.entity.ItemRecords;
import cn.harlan.service.ItemRecordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemRecordsServiceImpl implements ItemRecordsService{

    @Autowired
    ItemRecordsMapper mapper;

    @Override
    public List<ItemRecords> queryRuKu(Integer type) {
        return mapper.queryRuKu(type);
    }

    @Override
    public List<ItemMap> queryMap() {
        return mapper.queryMap();
    }

}
