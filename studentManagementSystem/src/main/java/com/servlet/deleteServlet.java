package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.StudentDAO;
import com.conn.DBconnect;

@WebServlet("/delete")
public class deleteServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int id = Integer.parseInt(req.getParameter("id"));
		StudentDAO dao = new StudentDAO(DBconnect.getConn());
		boolean f = dao.deleteStudent(id);

		HttpSession session = req.getSession();

		if (f) {
			session.setAttribute("succMsg", "deleted Successfully");
			resp.sendRedirect("index.jsp");
		} else {
			session.setAttribute("errorMsg", "Something went wrong...");
			resp.sendRedirect("index.jsp");
		}

	}

}