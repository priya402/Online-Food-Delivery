package com.food.DeliveryBoy;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.food.DataBase.Order;

@WebServlet("/DeliveryBoyOrder")
public class DeliveryBoyOrder extends HttpServlet {

	private static final long serialVersionUID = 8894059102873992208L;
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	HttpSession sesion=req.getSession();
		Order odr=new Order();
		
		if(req.getParameter("astatus")!=null)
		{
			String j="deliver";
			int k=Integer.parseInt(req.getParameter("astatus"));
			int s=odr.OrderUpdates(j, k);
			if(s>0)
				resp.sendRedirect("DeliveryBoy.jsp");
			else
				resp.sendRedirect("DeliveryBoy.jsp");
			
		}
		
		
		
	}
	

}
