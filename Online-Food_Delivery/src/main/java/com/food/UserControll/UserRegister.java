package com.food.UserControll;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.food.DataBase.UserDbOperation;
import com.food.Entity.User;

@WebServlet("/Register")
public class UserRegister extends HttpServlet {

	private static final long serialVersionUID = -2751146572547615632L;
	User user = new User();
	UserDbOperation op = new UserDbOperation();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		user.setUname(req.getParameter("name"));
		user.setEmail(req.getParameter("email"));
		user.setMno(req.getParameter("phone"));
		user.setAddress(req.getParameter("address"));
		user.setPass(req.getParameter("pass"));
		System.out.println(req.getRemoteAddr());
		int s=op.Insert(user);
		if(s>0)
			resp.sendRedirect("login.jsp");
		else
			resp.sendRedirect("CreateAccount.jsp");
	}

}
