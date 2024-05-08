package com.food.RestoruntControll;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.food.DataBase.RestoruntDbOperation;
import com.food.Entity.Restorunt;

@WebServlet("/RestoCreate")
public class RestoCreate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Restorunt rst=new Restorunt();
	RestoruntDbOperation db=new RestoruntDbOperation();
       
  
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			rst.setRname(req.getParameter("name"));
			rst.setRno(req.getParameter("phone"));
			rst.setAddress(req.getParameter("address"));
			rst.setEmail(req.getParameter("email"));
			rst.setPass(req.getParameter("pass"));
			int s=db.Insert(rst);
			if(s>0)
				res.sendRedirect("resto_login.jsp");
			else
				res.sendRedirect("resto_Create.jsp");
			
		
			
	}

}
