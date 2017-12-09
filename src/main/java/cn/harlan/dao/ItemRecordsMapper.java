package cn.harlan.dao;

import cn.harlan.entity.ItemMap;
import cn.harlan.entity.ItemRecords;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface ItemRecordsMapper {
    List<ItemRecords> queryRuKu(Integer type);
    List<ItemMap> queryMap();
}
