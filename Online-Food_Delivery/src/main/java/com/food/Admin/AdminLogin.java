package com.food.Admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.food.DataBase.AdminDao;
import com.food.Entity.Admin;

/**
 * Servlet implementation class AdminLogin
 */
@WebServlet("/AdminLogin")
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AdminDao adao = new AdminDao();
	Admin admin = adao.getInfo();
	
	Boolean login=false;

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.getSession().invalidate();
		HttpSession sesion = req.getSession();
		if (req.getParameter("submit") != null) {
			String email = req.getParameter("email");
			String pass = req.getParameter("pass");
//			System.out.println(admin.getEmail());
//			System.out.println(email);
//			System.out.println(pass);
//			System.out.println(admin.getPass());
			if (email.equals(admin.getEmail())&&pass.equals(admin.getPass())) {
					login=true;
			}
			if(login==true)
			{
				String status = "log";
				sesion.setAttribute("log", status);
				res.sendRedirect("admin_DeliveryBoy.jsp");
			}
			else
				res.sendRedirect("Admin.jsp");
		
		}
		
	}

}
