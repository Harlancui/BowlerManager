package cn.harlan.dao;

import cn.harlan.entity.Items;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
public interface ItemsMapper {

    public List<Items> queryListForPage();

    public int additem(Items items);

    public Items queryItem(Items items);

    public void deleteById(Items items);

    public Items queryItemById(Items items);

    public void update(Items items);
}
