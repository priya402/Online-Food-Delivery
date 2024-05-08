package com.food.DeliveryBoy;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.food.DataBase.DeliveryBoyDB;
import com.food.Entity.DeliveryBoy;

@WebServlet("/DeliveryBoyLogin")
public class DeliveryBoyLogin extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession sesion=req.getSession();
		Boolean flag=false;
		String log="nlog";
		String email=req.getParameter("email");
		String pass=req.getParameter("pass");
		DeliveryBoyDB db = new DeliveryBoyDB();
		List<DeliveryBoy> boy = db.getall();
		if (req.getParameter("submit") != null) {
			for (DeliveryBoy boy1 : boy) {
				if (boy1.getEmail().equals(email)
						&& boy1.getPass().equals(pass)) {
					flag = true;
					sesion.setAttribute("boyid", boy1.getId());
//					System.out.println(boy1.getEmail());
//					System.out.println("Boy Id"+boy1.getId());

				}
			}
			if(flag==true)
			{
				log="log";
				sesion.setAttribute("log", log);
				resp.sendRedirect("DeliveryBoy.jsp");
			}
			else
			{
				resp.sendRedirect("DeliveryBoyLogin.jsp");
			}
		}
		else
			resp.sendRedirect("DeliveryBoyLogin.jsp");

	}

}
