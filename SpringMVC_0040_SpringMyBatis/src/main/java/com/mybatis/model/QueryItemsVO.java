package com.mybatis.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by pl on 2015/9/24.
 */
public class QueryItemsVO {

    //商品信息
    private Items items;

    //扩展的商品信息
    private ItemsCustom itemsCustom;

    private List<ItemsCustom> itemsCustomList;

    private Map<String,Object> itemInfo = new HashMap<String,Object>();

    public Items getItems() {
        return items;
    }

    public void setItems(Items items) {
        this.items = items;
    }

    public ItemsCustom getItemsCustom() {
        return itemsCustom;
    }

    public void setItemsCustom(ItemsCustom itemsCustom) {
        this.itemsCustom = itemsCustom;
    }

    public List<ItemsCustom> getItemsCustomList() {
        return itemsCustomList;
    }

    public void setItemsCustomList(List<ItemsCustom> itemsCustomList) {
        this.itemsCustomList = itemsCustomList;
    }

    public Map<String, Object> getItemInfo() {
        return itemInfo;
    }

    public void setItemInfo(Map<String, Object> itemInfo) {
        this.itemInfo = itemInfo;
    }
}
