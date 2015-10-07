package com.springmvc.study.controller;

import com.springmvc.study.model.Items;
import org.springframework.web.HttpRequestHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by pl on 2015/9/23.
 */
public class ShowItems2Controller implements HttpRequestHandler {
    /**
     * 使用这个处理器比较接近于servelet,我们可以通过这个处理器灵活的处理HTTP响应头部信息
     * 比如修改响应的内容的类型
     * @param httpServletRequest
     * @param httpServletResponse
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
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
        items3.setName("笔记本4");
        items3.setDetail("好用的笔记本4");
        items3.setPrice(4200f);
        items3.setCreatetime(new Date());

        List<Items> itemsList = new ArrayList<Items>();
        itemsList.add(items1);
        itemsList.add(items2);
        itemsList.add(items3);

        httpServletRequest.setAttribute("itemsList",itemsList);
        httpServletRequest.getRequestDispatcher("/WEB-INF/jsp/itemsList.jsp").forward(httpServletRequest,httpServletResponse);
    }
}
