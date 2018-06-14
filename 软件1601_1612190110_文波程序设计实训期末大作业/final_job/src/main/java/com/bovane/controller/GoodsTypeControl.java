package com.bovane.controller;


import com.bovane.entity.GoodsType;
import com.bovane.service.GoodsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.PrintWriter;
import java.util.List;

@Controller
public class GoodsTypeControl {
    @Autowired
    private GoodsTypeService typeService;
    // 添加商品类型
    @RequestMapping("/admin/goodsTypes/doadd.do") // 添加商品类型
    public String doadd(PrintWriter out, GoodsType goodsType)  {
        int result = typeService.addGoodsType(goodsType);
        if(result>0){
            return  "redirect:/admin/goodsTypes/list.do";
        }else{
            out.println("添加失败！");
            return null;
        }
    }

    // 获取所有商品类别 mapping
    @RequestMapping("/admin/goodsTypes/list.do") // 列出所有类型
    public String list(HttpServletRequest request) {
        List<GoodsType> goodsTypes = typeService.getAll();
        request.setAttribute("goodsTypes", goodsTypes);
        return "admin/goodsType_list";
    }

    @RequestMapping("/admin/goodsTypes/del.do") // 删除类型
    public String dodel(PrintWriter out,int id) {
        int result = typeService.deleteGoodsType(id);
        if(result > 0)
            return  "redirect:/admin/goodsTypes/list.do";
        else {
            out.print("删除失败！");
            return null;
        }
    }
    @RequestMapping("/admin/goodsTypes/toedit.do") // 编辑类型
    public String toedit(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        GoodsType goodsType = typeService.selectByGoodsTypeID(id);
        request.setAttribute("oneType",goodsType);
        return "admin/goodsType_toedit";
    }

    @RequestMapping("/admin/goodsTypes/doedit.do") // 编辑类型
    public String doedit(PrintWriter out,GoodsType goodsType) {
        int result = typeService.updateGoodsType(goodsType);
        if(result>0){
            return  "redirect:/admin/goodsTypes/list.do";
        }else{
            out.println("更新失败！");
            return null;
        }
    }
}
