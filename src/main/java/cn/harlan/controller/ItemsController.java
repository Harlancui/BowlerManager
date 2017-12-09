package cn.harlan.controller;

import cn.harlan.entity.Items;
import cn.harlan.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemsController {

    @Autowired
    ItemsService itemsService;

    @RequestMapping(value = "/queryListForPage", method = RequestMethod.POST)
    @ResponseBody
    public List<Items> queryListForPage() {
        return itemsService.queryListForPage();
    }

    @RequestMapping(value = "/additem")
    @ResponseBody
    public Items additem(@RequestBody Items items) {
        items.setCreatetime(new Date());
        itemsService.additem(items);
        return items;
    }

    @RequestMapping(value = "/deleteById")
    public void deleteById(@RequestBody Items items){
        itemsService.deleteById(items);
    }

    @RequestMapping(value = "queryById")
    @ResponseBody
    public Items queryById(@RequestBody Items items){
        return itemsService.queryItemById(items);
    }

    @RequestMapping(value = "update")
    @ResponseBody
    public Items update(@RequestBody Items items){
        itemsService.update(items);
        return itemsService.queryItemById(items);
    }
}
