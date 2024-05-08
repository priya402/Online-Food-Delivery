package com.food.RestoruntControll;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.food.DataBase.RestoruntDbOperation;
import com.food.Entity.Restorunt;

@WebServlet("/RestoLogin")
public class RestoLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RestoruntDbOperation db = new RestoruntDbOperation();
	List<Restorunt> rs = db.getAll();
	Boolean flag = false;
	int rid;
	String log = "notlog";

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.getSession().invalidate();
		HttpSession sesion = req.getSession(true);
		String email = req.getParameter("email");
		String pass = req.getParameter("pass");
		if (req.getParameter("submit") != null) {
			
			for (Restorunt resto : rs) {
				if (resto.getEmail().equals(email) && resto.getPass().equals(pass))
					rid = resto.getRid();
					flag = true;
					sesion.setAttribute("rid", rid);
					//System.out.println(rid);
					break;

			}
			if (flag = true) {
				String log = "log";
				sesion.setAttribute("login", log);
				res.sendRedirect("restorunt.jsp");
			} else
				res.sendRedirect("resto_login.jsp");
		}
		
		if (req.getParameter("forgot") != null)
			res.sendRedirect("resto_forgot.jsp");

	}

}
