package com.food.Admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.food.DataBase.UserDbOperation;
import com.food.Entity.User;

@WebServlet("/AdminUser")
public class AdminUser extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		User rst = new User();
		UserDbOperation db = new UserDbOperation();
		HttpSession sesion = req.getSession();

		if (req.getParameter("add") != null) {
			rst = new User();
			rst.setAddress(req.getParameter("address"));
			rst.setEmail(req.getParameter("email"));
			rst.setPass(req.getParameter("pass"));
			rst.setUname(req.getParameter("name"));
			rst.setMno(req.getParameter("phno"));

			int s = db.Insert(rst);
			if (s > 0)
				res.sendRedirect("admin_user.jsp");
			else
				res.sendRedirect("admin_user.jsp");

		}
		if (req.getParameter("did") != null) {
			int k = Integer.parseInt(req.getParameter("did"));
			int s = db.Delete(k);
			if (s > 0) {
				res.sendRedirect("admin_user.jsp");
			}
		}
		if (req.getParameter("uid") != null) {
			sesion.setAttribute("uid", req.getParameter("uid"));
			res.sendRedirect("admin_user_update.jsp?uid=" + req.getParameter("uid"));

		}
		if (req.getParameter("update") != null) {
			rst = new User();
			rst.setAddress(req.getParameter("address"));
			rst.setEmail(req.getParameter("email"));
			rst.setPass(req.getParameter("pass"));
			rst.setUname(req.getParameter("name"));
			rst.setMno(req.getParameter("phno"));
			rst.setId((int) sesion.getAttribute("uid"));

			int s = db.UpdateUser(rst);
			if (s > 0)
				res.sendRedirect("admin_user.jsp");
			else
				res.sendRedirect("admin_user_update.jsp?uid=" + sesion.getAttribute("uid"));
		}

	}

}
