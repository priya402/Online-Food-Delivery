package com.food.RestoruntControll;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.food.DataBase.RestoruntDbOperation;
import com.food.DataBase.RestoruntMenu;
import com.food.Entity.MenuItem;

@WebServlet("/restorunt")
@MultipartConfig
public class Restorunt extends HttpServlet {

	private static final long serialVersionUID = 9073971944008277357L;
	MenuItem menu;
	RestoruntMenu menudb = new RestoruntMenu();
	RestoruntDbOperation rdb = new RestoruntDbOperation();

	@Override
	protected void service (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession sesion = req.getSession();
		
		
		if (req.getParameter("add") != null) {
			menu = new MenuItem();
			menu.setName(req.getParameter("name"));
			menu.setPrice(req.getParameter("price"));
			menu.setDescription(req.getParameter("description"));
			menu.setType(req.getParameter("type"));
			menu.setResto_id((Integer)sesion.getAttribute("rid"));
			menu.setDiscount(Integer.parseInt(req.getParameter("discount")));

			Part file = req.getPart("image");
			String imgFileName = file.getHeader("content-disposition");
			String [] items=imgFileName.split(";");
			String filename=null;
			for(String s:items)
			{
				if(s.trim().startsWith("filename"))
				{
					filename=s.substring(s.indexOf("=")+2,s.length()-1);
				}
			}	
			String UploadPath = "/home/yash/eclipse-workspace/Online-Food_Delivery/src/main/webapp/images/" + filename;
			System.out.println(UploadPath);
			FileOutputStream fos = new FileOutputStream(UploadPath);
			InputStream is = file.getInputStream();
			byte[] data=new byte[is.available()];
			is.read(data);
			fos.write(data);
			fos.close();
			menu.setImage(filename);
			int s = menudb.addMenu(menu);
			if(s>0)
				resp.sendRedirect("restorunt.jsp");
			
			
		}
		if(req.getParameter("did")!=null)
		{
			menu=new MenuItem();
			menu.setId(Integer.parseInt(req.getParameter("did")));
			menu.setResto_id(Integer.parseInt(req.getParameter("rdid")));
			int s=menudb.deleteMenu(menu);
			if(s>0)
			{
				sesion.setAttribute("delete", "Item is Deleted "+req.getParameter("did"));
				resp.sendRedirect("restorunt.jsp");
			}
		}
		
		if(req.getParameter("uid")!=null)
		{
			//System.out.println(req.getParameter("uid"));
			resp.sendRedirect("resto_menu_update.jsp?uid="+req.getParameter("uid")+"&urid="+req.getParameter("urid"));
		}
		
		if(req.getParameter("update")!=null)
		{
			
			menu=new MenuItem();
			menu.setId((int)sesion.getAttribute("uid"));
			menu.setName(req.getParameter("Updatename"));
			menu.setDiscount(Integer.parseInt(req.getParameter("updatediscount")));
			menu.setResto_id((int)sesion.getAttribute("urid"));
			menu.setPrice(req.getParameter("Updateprice"));
			menu.setType(req.getParameter("updatetype"));
			menu.setDescription(req.getParameter("updateDesc"));
			
			
			
			int s=menudb.updateMenu(menu);
			if(s>0)
				resp.sendRedirect("restorunt.jsp");
			else
			{
				sesion.setAttribute("Updateerror", "Something Went Wrong");
				resp.sendRedirect("resto_menu_update.jsp?uid="+req.getParameter("uid"));
				
			}
		}
		
		}
		
		
	}

