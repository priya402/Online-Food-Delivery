package com.food.UserControll;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.food.DataBase.UserDbOperation;
import com.food.Entity.User;

@WebServlet("/login")
public class UserLogin extends HttpServlet {

	private static final long serialVersionUID = -6789395685420301871L;
	UserDbOperation db = new UserDbOperation();
	List<User> user;
	Boolean flag = false;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		req.getSession().invalidate();
		String uname = (String) req.getParameter("email");
		String pass = (String) req.getParameter("pass");
		String status="loged";
		HttpSession sesion = req.getSession();
		if (req.getParameter("submit") != null) {
			
			user = db.getAll();
			for (User user2 : user) {
				if (user2.getEmail().equals(uname) && user2.getPass().equals(pass)) {

					flag = true;
					sesion.setAttribute("uname", user2.getUname());
					sesion.setAttribute("cid", user2.getMno());
					//sesion.setAttribute("cli", user2.getId());
				
					
				}
			}
			if (flag == true) {
				status = "log";
				sesion.setAttribute("status", status);
				req.setAttribute("status", status);

				res.sendRedirect("Home.jsp");
			} else
				res.sendRedirect("login.jsp");
		}
		
		if (req.getParameter("forgot") != null)
			res.sendRedirect("Forgot.jsp");
	}

}
