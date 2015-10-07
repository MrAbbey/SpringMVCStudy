package com.mybatis.controller;
import com.mybatis.exception.CustomException;
import com.mybatis.model.Items;
import com.mybatis.model.ItemsCustom;
import com.mybatis.model.QueryItemsVO;
import com.mybatis.service.ItemsService;
import com.mybatis.validation.MyGroup1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by pl on 2015/9/24.
 */
@Controller
//使用根路径来对URL进行分类
@RequestMapping("/items")
public class ShowItemsController {
    @Autowired
    private ItemsService itemsService;

    @ModelAttribute("itemtypes")
    public Map<String, String> getItemTypes(){

        Map<String, String> itemTypes = new HashMap<String,String>();
        itemTypes.put("101", "数码");
        itemTypes.put("102", "母婴");

        return itemTypes;
    }

    //绑定包装类型的参数
    @RequestMapping("/queryItems.action")
    public ModelAndView queryItems(QueryItemsVO queryItemsVO) throws Exception{
        List<ItemsCustom> itemsList = itemsService.findItemsList(queryItemsVO);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("itemsList",itemsList);
        modelAndView.setViewName("items/itemsList");
        return modelAndView;
    }

    //绑定包装类型的参数
    @RequestMapping("/editQueryItems.action")
    public ModelAndView editQueryItems(QueryItemsVO queryItemsVO) throws Exception{
        List<ItemsCustom> itemsList = itemsService.findItemsList(queryItemsVO);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("itemsList",itemsList);
        modelAndView.setViewName("items/editItemsList");
        return modelAndView;
    }

    @RequestMapping("/queryItemsDetail.action")
    public String queryItemsDetail(Model model,Integer id) throws Exception{
        Items items = itemsService.findItemsById(id);
        if(items == null){
            throw new CustomException("商品信息获取失败");
        }else {
            model.addAttribute("items", items);
            return "items/editItem";
        }
    }

    @RequestMapping(value="/updateItems.action",method = {RequestMethod.POST})
    public String updateItems(HttpServletRequest request,Integer id,@Validated(value={MyGroup1.class})  @ModelAttribute("items") ItemsCustom itemsCustom, BindingResult bindingResult) throws Exception{
        if(bindingResult.hasErrors()){
            List<ObjectError> objectErrors = bindingResult.getAllErrors();
            for(ObjectError error: objectErrors){
                System.out.println(error.getDefaultMessage());
                System.out.println(error.getCode());
            }
            return "items/editItem";
        }
        itemsService.updateItems(id,itemsCustom);
        return "redirect:queryItems.action";
    }

    @RequestMapping(value="/editItemsSubmit.action",method = {RequestMethod.POST})
    public String editItemsSubmit(Items items, MultipartFile pictureFile) throws Exception{
        //原始文件名称
        String pictureFile_name =  pictureFile.getOriginalFilename();
        //新文件名称
        String newFileName = UUID.randomUUID().toString()+pictureFile_name.substring(pictureFile_name.lastIndexOf("."));

        //上传图片
        File uploadPic = new java.io.File("d:/develop/upload/temp/"+newFileName);

        if(!uploadPic.exists()){
            uploadPic.mkdirs();
        }
        //向磁盘写文件
        pictureFile.transferTo(uploadPic);
        return "redirect:queryItems.action";
    }

    //绑定数组类型的参数
    @RequestMapping(value="/deleteItems.action",method = {RequestMethod.GET})
    public String deleteItems(Integer item_ids[]) throws Exception{
        return "redirect:queryItems.action";
    }

    //绑定List类型的参数
    @RequestMapping(value="/batchAddItems.action",method = {RequestMethod.GET})
    public String batchAddItems(QueryItemsVO queryItemsVO) throws Exception{
        return "redirect:queryItems.action";
    }

    //绑定Map类型的参数
    @RequestMapping(value="/batchUpdateItems.action",method = {RequestMethod.POST})
    public String batchUpdateItems(QueryItemsVO queryItemsVO) throws Exception{
        return "redirect:queryItems.action";
    }

    // 商品修改提交json信息，响应json信息
    @RequestMapping("/editItemSubmit_RequestJson")
    public @ResponseBody Items editItemSubmit_RequestJson(Items items) throws Exception {
        System.out.println(items);
        //itemService.saveItem(items);
        return items;

    }
}
