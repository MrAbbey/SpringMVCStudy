package com.springmvc.study.controller;

import com.springmvc.study.model.Items;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by pl on 2015/9/23.
 */
public class ShowItemsController implements Controller {
    @Override
    public ModelAndView handleRequest(javax.servlet.http.HttpServletRequest httpServletRequest, javax.servlet.http.HttpServletResponse httpServletResponse) throws Exception {
        Items items1 = new Items();
        items1.setId(1);
        items1.setName("笔记本");
        items1.setDetail("好用的笔记本");
        items1.setPrice(4000f);
        items1.setCreatetime(new Date());

        Items items2 = new Items();
        items2.setId(1);
        items2.setName("笔记本2");
        items2.setDetail("好用的笔记本2");
        items2.setPrice(4200f);
        items2.setCreatetime(new Date());

        Items items3 = new Items();
        items3.setId(1);
        items3.setName("笔记本3");
        items3.setDetail("好用的笔记本3");
        items3.setPrice(4200f);
        items3.setCreatetime(new Date());

        List<Items> itemsList = new ArrayList<Items>();
        itemsList.add(items1);
        itemsList.add(items2);
        itemsList.add(items3);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("itemsList",itemsList);
        modelAndView.setViewName("/WEB-INF/jsp/itemsList.jsp");
        return modelAndView;
    }
}
