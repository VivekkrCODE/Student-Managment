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
import com.entity.Student;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String name = req.getParameter("name");
		String dob = req.getParameter("dob");
		String address = req.getParameter("address");
		String qualification = req.getParameter("qualification");
		String email = req.getParameter("email");

		Student student = new Student(name, dob, address, qualification, email);
		HttpSession session = req.getSession();
		StudentDAO dao = new StudentDAO(DBconnect.getConn());
		boolean f = dao.addStudent(student);
		if (f) {
			session.setAttribute("succMsg", "Submitted Successfully");
			resp.sendRedirect("addStudent.jsp");
		} else {
			session.setAttribute("errorMsg", "Something went wrong...");
			resp.sendRedirect("addStudent.jsp");
		}

	}

}
