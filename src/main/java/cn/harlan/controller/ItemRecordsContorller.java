package cn.harlan.controller;

import cn.harlan.entity.End;
import cn.harlan.entity.ItemMap;
import cn.harlan.entity.ItemRecords;
import cn.harlan.entity.QueryUtil;
import cn.harlan.service.ItemRecordsService;
import org.omg.PortableInterceptor.INACTIVE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/record")
public class ItemRecordsContorller {

    @Autowired
    ItemRecordsService service;

    @RequestMapping(value = "/queryRuKu",method = RequestMethod.POST)
    public List<ItemRecords> queryRuKu(){
        /*0为入库*/
        return  service.queryRuKu(0);
    }

    @RequestMapping(value = "/queryChuKu",method = RequestMethod.POST)
    public List<ItemRecords> queryChuKu(){
        /*1为出库*/
        return service.queryRuKu(1);
    }

    @RequestMapping(value = "queryMap",method = RequestMethod.POST)
    public List<ItemMap> queryMap(){
        return service.queryMap();
    }

    @RequestMapping(value = "rukuadd",method = RequestMethod.POST)
    public ItemRecords add(@RequestBody ItemRecords itemRecords){
        Integer price = service.queryPrice(itemRecords.getItem_id());
        Double allprice = Double.valueOf(price*itemRecords.getNumber());
        itemRecords.setAllprice(allprice);
        itemRecords.setTime(new Date());
        itemRecords.setType(0);
        service.kucunadd(itemRecords);
        service.putinadd(itemRecords);
        return itemRecords;
    }
    @RequestMapping(value = "chukuadd",method = RequestMethod.POST)
    public ItemRecords cadd(@RequestBody ItemRecords itemRecords){
        if (service.checknumber(itemRecords.getItem_id())< itemRecords.getNumber()){
            itemRecords.setId(0);
        }else{
            Integer price = service.queryPrice(itemRecords.getItem_id());
            Double allprice = Double.valueOf(price*itemRecords.getNumber());
            itemRecords.setAllprice(allprice);
            itemRecords.setTime(new Date());
            itemRecords.setType(1);
            service.chukuadd(itemRecords);
            service.putinadd(itemRecords);
        }
        return itemRecords;
    }

    @RequestMapping(value = "queryAllRecord",method = RequestMethod.POST)
    public End queryAllRecord(@RequestBody QueryUtil util){
        System.out.println(util.toString());
        return null;
    }

}
