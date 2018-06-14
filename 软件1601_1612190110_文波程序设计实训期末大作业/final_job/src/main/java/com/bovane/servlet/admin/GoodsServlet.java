package com.bovane.servlet.admin;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bovane.entity.Goods;
import com.bovane.entity.GoodsType;
import com.bovane.service.GoodsService;
import com.bovane.service.GoodsTypeService;
import com.bovane.service.impl.GoodsServiceImpl;
import com.bovane.service.impl.GoodsTypeServiceImpl;

public class GoodsServlet extends HttpServlet {
    private GoodsService service = new GoodsServiceImpl();
    private GoodsTypeService typeService = new GoodsTypeServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String action=request.getParameter("op");
        if("toadd".equals(action)){
            toAdd(request, response);
        }else if("doadd".equals(action)){
            doAdd(request, response);
        }else if("list".equals(action)){
            list(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
    // 获取商品类别并存于session
    protected void toAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<GoodsType> types = typeService.getAll();
        request.setAttribute("types", types);
        request.getRequestDispatcher("/admin/goods_toadd.jsp").forward(request, response);
    }
    // 获取所有商品并存于session
    protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Goods> goods = service.getAll();
        request.setAttribute("goods", goods);
        request.getRequestDispatcher("/admin/goods_list.jsp").forward(request, response);
    }
    // 添加商品
    public void doAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String goodsName = request.getParameter("goodsName");
        int typeid = Integer.parseInt(request.getParameter("id"));
        double goodsPrice = Double.parseDouble(request.getParameter("goodsPrice"));
        String goodsDesc = request.getParameter("goodsDesc");
        int stock = Integer.parseInt(request.getParameter("stock"));
        Goods goods = new Goods();
        goods.setGoodsName(goodsName);
        goods.setGoodsPrice(goodsPrice);
        goods.setDescription(goodsDesc);
        goods.setStock(stock);
        GoodsType goodsType = new GoodsType();
        goodsType.setId(typeid);
        goods.setGoodsType(goodsType);

        int result = service.addGoods(goods);
        if(result>0){
          response.sendRedirect(request.getContextPath()+"/admin/goods.do?op=list");
        }else{
            response.getWriter().println("插入失败！");
        }
    }
    public void doDel(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        int result = service.deleteGoods(id);
        if(result>0){
            response.sendRedirect(request.getContextPath()+"/admin/goods.do?op=list");
        }else{
            response.getWriter().println("删除失败！");
        }
    }
    public void toEdit(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Goods goods = service.selectByGoodsID(id);
        if(goods!=null) {
            List<GoodsType> types = typeService.getAll();
            request.setAttribute("types", types);
            request.setAttribute("oneGoods",goods);
            request.getRequestDispatcher("/admin/goods_toedit.jsp").forward(request, response);
        }
    }
    public void doEdit (HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
        String goodsName = request.getParameter("goodsName");
        int typeid = Integer.parseInt(request.getParameter("id"));
        double goodsPrice = Double.parseDouble(request.getParameter("goodsPrice"));
        String goodsDesc = request.getParameter("goodsDesc");
        int stock = Integer.parseInt(request.getParameter("stock"));
        Goods goods = new Goods();
        goods.setGoodsName(goodsName);
        goods.setGoodsPrice(goodsPrice);
        goods.setDescription(goodsDesc);
        goods.setStock(stock);
        GoodsType goodsType = new GoodsType();
        goodsType.setId(typeid);
        goods.setGoodsType(goodsType);

        int result = service.updateGoods(goods);
        if(result>0){
            response.sendRedirect(request.getContextPath()+"/admin/goods.do?op=list");
        }else{
            response.getWriter().println("更新失败！");
        }
    }


}
