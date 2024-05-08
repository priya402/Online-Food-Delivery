package com.food.Admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.food.DataBase.RestoruntDbOperation;
import com.food.Entity.Restorunt;

@WebServlet("/AdminRestorunt")
public class AdminRestorunt extends HttpServlet {
	
	private static final long serialVersionUID = -8363667357022102278L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Restorunt rst=new Restorunt();
		RestoruntDbOperation db=new RestoruntDbOperation();
		HttpSession sesion=req.getSession();
		
		if(req.getParameter("add")!=null)
		{
			rst=new Restorunt();
			rst.setAddress(req.getParameter("address"));
			rst.setEmail(req.getParameter("email"));
			rst.setPass(req.getParameter("pass"));
			rst.setRname(req.getParameter("name"));
			rst.setRno(req.getParameter("phon"));
			
			int s=db.Insert(rst);
			if(s>0)
				res.sendRedirect("admin_resto.jsp");
			else
				res.sendRedirect("admin_resto.jsp");
			
		}
		if(req.getParameter("dri")!=null)
		{
			int k=Integer.parseInt(req.getParameter("dri"));
			int s=db.Delete(k);
			if(s>0) {
				res.sendRedirect("admin_resto.jsp");
			}
		}
		if(req.getParameter("uri")!=null)
		{
			sesion.setAttribute("uri", req.getParameter("uri"));
			res.sendRedirect("admin_resto_update.jsp?uri="+req.getParameter("uri"));
			
		}
		if(req.getParameter("update")!=null)
		{
			rst=new  Restorunt();
			rst.setAddress(req.getParameter("address"));
			rst.setEmail(req.getParameter("email"));
			rst.setPass(req.getParameter("pass"));
			rst.setRname(req.getParameter("name"));
			rst.setRno(req.getParameter("phno"));
			rst.setRid((int)sesion.getAttribute("uri"));
			
			int s=db.UpdateInfo(rst);
			if(s>0)
				res.sendRedirect("admin_resto.jsp");
			else
				res.sendRedirect("admin_resto_update.jsp?uri="+sesion.getAttribute("uri"));
		}
		

}
}
