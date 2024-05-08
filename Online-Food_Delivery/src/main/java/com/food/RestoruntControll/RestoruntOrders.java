package com.food.RestoruntControll;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.food.DataBase.Order;

/**
 * Servlet implementation class RestoruntOrders
 */
@WebServlet("/RestoruntOrders")
public class RestoruntOrders extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//req.getSession().invalidate();
		Order odr=new Order();
		if(req.getParameter("astatus")!=null)
		{
			int i=Integer.parseInt(req.getParameter("astatus"));
			String status="reject";
			int s=odr.OrderUpdates(status, i);
			if(s>0)
				res.sendRedirect("resto_order.jsp");
			else
				res.sendRedirect("resto_order.jsp");
		}
		if(req.getParameter("assign")!=null)
		{
			int boy=Integer.parseInt(req.getParameter("boy"));
			//System.out.println("Boy Boy"+boy);
			int mid=Integer.parseInt(req.getParameter("mid"));
			//System.out.println(boy+"\t"+mid);
		int s=odr.OrderDelivery(mid,boy);
		if(s>0)
				res.sendRedirect("resto_order.jsp");
		else
			res.sendRedirect("resto_order.jsp");
		}
	}

}
