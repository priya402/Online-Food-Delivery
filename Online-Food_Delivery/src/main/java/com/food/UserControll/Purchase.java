package com.food.UserControll;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.food.DataBase.Order;
import com.food.DataBase.RestoruntDbOperation;
import com.food.DataBase.RestoruntMenu;
import com.food.Entity.MenuItem;
import com.food.Entity.Orders;
import com.food.Entity.Restorunt;

/**
 * Servlet implementation class Purchase
 */
@WebServlet("/Purchase")
public class Purchase extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String uname = (String) session.getAttribute("uname");
		RestoruntMenu menu = new RestoruntMenu();
		RestoruntDbOperation db = new RestoruntDbOperation();
		List<MenuItem> item = menu.getAllMenu();
		List<Restorunt> resto = db.getAll();
		List<MenuItem> AllOrder = (List<MenuItem>) session.getAttribute("Order");
		
		List<Integer> cart = (List<Integer>) session.getAttribute(uname + "cart");
		List<Orders> order = new ArrayList<>();
		Orders ord = null;
		LocalDate date = LocalDate.now();
		Date tdate =Date.valueOf(date);
		String cid=(String)session.getAttribute("cid");
		if (req.getParameter("purchace") != null) {
			for (Integer car : cart) {
				for (Restorunt rest : resto) {
					for (MenuItem m : item) {
						if (cart.contains(m.getId())&&m.getResto_id()==rest.getRid()) {
							ord = new Orders();
							ord.setCid(cid);
							ord.setMid(m.getId());
							ord.setRid(rest.getRid());
							ord.setDate(tdate);
							ord.setPrice(req.getParameter("buy"));
							order.add(ord);
							
						}
						
					}
					
					
				}
				break;

			}
			Order od=new Order();
			
			int s=od.Insert(order);
			if(s>0)
			{
				session.removeAttribute(uname+"cart");
				res.sendRedirect("Accout.jsp");
			}
			else
				res.sendRedirect("purchace.jsp");
			

		}
		if(req.getParameter("cancle")!=null) {
			res.sendRedirect("purchace.jsp");
			}
		}

}
