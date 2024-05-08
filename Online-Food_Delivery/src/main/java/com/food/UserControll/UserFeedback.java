package com.food.UserControll;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.food.DataBase.FeedBackDB;
import com.food.Entity.Feedback;

@WebServlet("/FeedBack")
public class UserFeedback extends HttpServlet {

	private static final long serialVersionUID = -6338861280002314243L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Feedback feed = new Feedback();
		FeedBackDB db = new FeedBackDB();
		
		if (req.getParameter("sub") != null) {
			feed = new Feedback();
			feed.setEmail(req.getParameter("email"));
			feed.setName(req.getParameter("uname"));
			feed.setPhno(req.getParameter("pno"));
			feed.setFeedback(req.getParameter("feedback"));
			int s = db.InsertFeedback(feed);
			if (s > 0)
				res.sendRedirect("FeedBack.jsp");
			else
				res.sendRedirect("FeedBack.jsp");

		}

	}

}
