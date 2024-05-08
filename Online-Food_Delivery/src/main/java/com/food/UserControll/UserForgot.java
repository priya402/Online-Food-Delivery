package com.food.UserControll;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.food.DataBase.UserDbOperation;
import com.food.Entity.User;

@WebServlet("/forgot")
public class UserForgot extends HttpServlet {
	UserDbOperation db=new UserDbOperation();
	User u=new User();
	private static final long serialVersionUID = 3172398859035933995L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email=req.getParameter("email");
		String pno=req.getParameter("pno");
		String pass=req.getParameter("pass");
		u.setEmail(email);
		u.setMno(pno);
		u.setPass(pass);
		int s=db.Update(u);
		
		if(s>0)
			resp.sendRedirect("login.jsp");
		else
			resp.sendRedirect("Forgot.jsp");
		
	}

}
