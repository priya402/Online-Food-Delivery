package com.food.RestoruntControll;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.food.DataBase.DeliveryBoyDB;
import com.food.Entity.DeliveryBoy;

/**
 * Servlet implementation class RestoDeliveryBoy
 */
@WebServlet("/RestoDeliveryBoy")
public class RestoDeliveryBoy extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
		protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		DeliveryBoy boy;
		DeliveryBoyDB db=new DeliveryBoyDB();
		HttpSession sesion=req.getSession();

		if(req.getParameter("sub")!=null)
		{
			boy=new  DeliveryBoy();
			boy.setName(req.getParameter("name"));
			boy.setAddress(req.getParameter("address"));
			boy.setEmail(req.getParameter("email"));
			boy.setPhno(req.getParameter("phno"));
			boy.setPass(req.getParameter("pass"));
			
			int s=db.InsertInfo(boy);
			if(s>0)
				res.sendRedirect("Boy_Acc.jsp");
			else
				res.sendRedirect("Boy_Acc.jsp");
			
			
		}
		}

}
