package com.bovane.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bovane.entity.Goods;
import com.bovane.entity.GoodsType;
import com.bovane.service.GoodsService;
import com.bovane.service.GoodsTypeService;

@Controller
public class GoodsControl {
	@Autowired
  private GoodsTypeService service;
	@Autowired
	private GoodsService goodsService;
	// 添加获得types mapping
	@RequestMapping("/admin/goods/toadd.do")
	public String toadd(HttpServletRequest request)  {
		List<GoodsType> types = service.getAll();
		request.setAttribute("types", types);
		return "admin/goods_toadd";
	}
	// 添加mapping
	@RequestMapping("/admin/goods/doadd.do")
	public String doadd(PrintWriter out,Goods goods)  {
		int result = goodsService.addGoods(goods);
		if(result>0){
			return  "redirect:/admin/goods/list.do";
		}else{
			out.println("添加失败！");
			return null;
		}
	}
	// 获取所有商品 mapping
	@RequestMapping("/admin/goods/list.do")
	public String list(HttpServletRequest request) {
		List<Goods> goods = goodsService.getAll();
		request.setAttribute("goods", goods);
		return "admin/goods_list";
	}
	// 删除商品mapping
	@RequestMapping("/admin/goods/del.do")
	public String dodel(PrintWriter out,int id) {
        int result = goodsService.deleteGoods(id);
        if (result > 0) {
            return "redirect:/admin/goods/list.do";
        } else {
            out.println("删除失败！");
            return null;
        }
    }
    // 编辑mapping
	@RequestMapping("/admin/goods/toedit.do")
    public String toEdit(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
        Goods goods = goodsService.selectByGoodsID(id);
        request.setAttribute("oneGoods",goods);
        return "admin/goods_toedit";
	}
	// 编辑mapping
    @RequestMapping("/admin/goods/doedit.do")
    public String doEdit(PrintWriter out,Goods goods) {
        int result = goodsService.updateGoods(goods);
        if(result>0){
            return  "redirect:/admin/goods/list.do";
        }else{
            out.println("更新失败！");
            return null;
        }
    }
}
