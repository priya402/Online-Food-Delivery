package com.food.UserControll;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/AddCart")
public class AddCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service (HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession sesion = req.getSession();
		if(sesion.getAttribute("status")==null)
				res.sendRedirect("login.jsp");
		else
		{
		int id=Integer.parseInt(req.getParameter("id"));
		String uname=(String)sesion.getAttribute("uname");
		@SuppressWarnings("unchecked")
		List<Integer> cart=(List<Integer>)sesion.getAttribute(uname+"cart");
		if(cart==null)
			cart=new ArrayList<>();
			cart.add(id);
		sesion.setAttribute(uname+"cart", cart);

		//System.out.println(id);
		res.sendRedirect(req.getHeader("referer"));
	}
		if(req.getParameter("did")!=null)
		{
			//System.out.println(req.getParameter("did"));
			String uname=(String)sesion.getAttribute("uname");
			List<Integer> cart=(List<Integer>)sesion.getAttribute(uname+"cart");
			int id=Integer.parseInt(req.getParameter("id"));
			Iterator<Integer> iter=cart.iterator();
			while(iter.hasNext())
			{
				int j=iter.next();
				if(id==j)
					iter.remove();
				
			}
		
		}
	}

}
