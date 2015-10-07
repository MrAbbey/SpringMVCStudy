package com.mybatis.service;

import com.mybatis.model.ItemsCustom;
import com.mybatis.model.QueryItemsVO;

import java.util.List;

/**
 * Created by pl on 2015/9/24.
 */
public interface ItemsService {
    public List<ItemsCustom> findItemsList(QueryItemsVO queryItemsVO) throws Exception;

    public ItemsCustom findItemsById(Integer id) throws Exception;

    public void updateItems(Integer id,ItemsCustom itemsCustom) throws Exception;
}
