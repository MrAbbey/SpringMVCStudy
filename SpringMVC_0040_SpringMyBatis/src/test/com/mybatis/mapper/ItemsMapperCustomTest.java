package com.mybatis.mapper;
import com.mybatis.model.ItemsCustom;
import com.mybatis.model.QueryItemsVO;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.List;
public class ItemsMapperCustomTest {

    @org.junit.Test
    public void testFindItemsList() throws Exception {
        ClassPathXmlApplicationContext context =new ClassPathXmlApplicationContext("spring/applicationContext-dao.xml");

        ItemsMapperCustom itemsMapperCustom = context.getBean("itemsMapperCustom",ItemsMapperCustom.class);

        ItemsCustom itemsCustom = new ItemsCustom();
        itemsCustom.setName("笔记本");
        QueryItemsVO queryItemsVO = new QueryItemsVO();
        queryItemsVO.setItemsCustom(itemsCustom);

        List<ItemsCustom> customList =  itemsMapperCustom.findItemsList(queryItemsVO);

        System.out.println(customList.size());
    }
}