package com.bovane.servlet.admin;

import com.bovane.entity.GoodsType;
import com.bovane.service.GoodsTypeService;
import com.bovane.service.impl.GoodsTypeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class GoodsTypeServlet extends HttpServlet {
    private GoodsTypeService typeService = new GoodsTypeServiceImpl();

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException ,IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String action = request.getParameter("op");
        if ("toadd".equals(action)) {
            doadd(request, response);
        }
        else if ("list".equals(action)) {
            list(request, response);
        }
    }
    public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        doPost(request,response);
    }
    // do add kind
    public void doadd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String name = request.getParameter("typeName");
        GoodsType goodsType = new GoodsType();
        goodsType.setName(name);
        int result = typeService.addGoodsType(goodsType);
        if(result>0) {
            response.sendRedirect(request.getContextPath()+"/admin/goodsTypes.do?op=list");
        }
        else {
            response.getWriter().println("插入失败！");
        }
    }
    // list kind
    public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        List<GoodsType> goodsTypes = typeService.getAll();
        request.setAttribute("goodsTypes", goodsTypes);
        request.getRequestDispatcher("/admin/goodsType_list.jsp").forward(request, response);
    }
    // delete kind
    public void dodel(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        int result= typeService.deleteGoodsType(id);
        if(result>0){
            response.sendRedirect(request.getContextPath()+"/admin/goodsTypes.do?op=list");
        }else{
            response.getWriter().println("删除失败！");
        }
    }
    public void toEdit(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        GoodsType goodsType = typeService.selectByGoodsTypeID(id);
        if(goodsType!=null) {
            request.setAttribute("oneType",goodsType);
            request.getRequestDispatcher("/admin/goodsType_toedit.jsp").forward(request, response);
        }
    }
    public void doEdit (HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
        String typeName = request.getParameter("typeName");
        GoodsType goodsType = new GoodsType();
        goodsType.setName(typeName);
        int result = typeService.updateGoodsType(goodsType);
        if(result>0){
            response.sendRedirect(request.getContextPath()+"/admin/goodsTypes.do?op=list");
        }else{
            response.getWriter().println("更新失败！");
        }
    }

}
