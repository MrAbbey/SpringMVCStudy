package com.mybatis.service.impl;

import com.mybatis.mapper.ItemsMapper;
import com.mybatis.mapper.ItemsMapperCustom;
import com.mybatis.model.Items;
import com.mybatis.model.ItemsCustom;
import com.mybatis.model.QueryItemsVO;
import com.mybatis.service.ItemsService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by pl on 2015/9/24.
 */
public class ItemsServiceImpl implements ItemsService{

    @Autowired
    private ItemsMapperCustom itemsMapperCustom;

    @Autowired
    private ItemsMapper itemsMapper;

    public List<ItemsCustom> findItemsList(QueryItemsVO queryItemsVO) throws Exception{
        return itemsMapperCustom.findItemsList(queryItemsVO);
    }

    @Override
    public ItemsCustom findItemsById(Integer id) throws Exception {
        Items items = itemsMapper.selectByPrimaryKey(id);

        ItemsCustom itemsCustom = new ItemsCustom();

        BeanUtils.copyProperties(items,itemsCustom);

        return itemsCustom;
    }

    @Override
    public void updateItems(Integer id, ItemsCustom itemsCustom) throws Exception {
        itemsCustom.setId(id);
        itemsMapper.updateByPrimaryKeyWithBLOBs(itemsCustom);
    }
}
