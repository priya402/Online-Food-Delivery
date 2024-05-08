package com.food.Admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.food.DataBase.DeliveryBoyDB;
import com.food.Entity.DeliveryBoy;

@WebServlet("/AdminDelivery")
public class AdminDeliveryBoy extends HttpServlet{
	
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		DeliveryBoy boy;
		DeliveryBoyDB db=new DeliveryBoyDB();
		HttpSession sesion=req.getSession();

		if(req.getParameter("addBoy")!=null)
		{
			boy=new  DeliveryBoy();
			boy.setName(req.getParameter("name"));
			boy.setAddress(req.getParameter("address"));
			boy.setEmail(req.getParameter("email"));
			boy.setPhno(req.getParameter("phno"));
			boy.setPass(req.getParameter("pass"));
			
			int s=db.InsertInfo(boy);
			if(s>0)
				res.sendRedirect("admin_DeliveryBoy.jsp");
			else
				res.sendRedirect("admin_DeliveryBoy.jsp");
			
			
		}
		if(req.getParameter("dboy")!=null)
		{	int k=Integer.parseInt(req.getParameter("dboy"));
			int s=db.InfoDelete(k);
			
			if(s>0) {
				res.sendRedirect("admin_DeliveryBoy.jsp");
			}

		}
		if(req.getParameter("uboy")!=null)
		{
			sesion.setAttribute("uboy", req.getParameter("uboy"));
			res.sendRedirect("admin_DeliveryBoy_update.jsp?uboy="+req.getParameter("uboy"));
		}
		if(req.getParameter("update")!=null)
		{
			boy=new DeliveryBoy();
			boy.setName(req.getParameter("name"));
			boy.setAddress(req.getParameter("address"));
			boy.setEmail(req.getParameter("email"));
			boy.setPass(req.getParameter("pass"));
			boy.setPhno(req.getParameter("Phno"));
			boy.setId((int)sesion.getAttribute("uboy"));
			
			int s=db.InfoUpdate(boy);
			if(s>0)
				res.sendRedirect("admin_DeliveryBoy.jsp");
			else
				res.sendRedirect("admin_DeliveryBoy_update.jsp?uboy="+sesion.getAttribute("uboy"));
		}
	}

}
