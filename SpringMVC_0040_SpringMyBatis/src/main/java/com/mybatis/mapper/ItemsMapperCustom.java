package com.mybatis.mapper;

import com.mybatis.model.ItemsCustom;
import com.mybatis.model.QueryItemsVO;

import java.util.List;

/**
 * Created by pl on 2015/9/24.
 */
public interface ItemsMapperCustom {
    /**
     * 查询商品列表
     * @param queryItemsVO
     * @return
     * @throws Exception
     */
    public List<ItemsCustom> findItemsList(QueryItemsVO queryItemsVO) throws Exception;
}
