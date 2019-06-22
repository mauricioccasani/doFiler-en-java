package com.mauricio;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");

		StringBuilder error = new StringBuilder(0);
		
		HttpSession httpSession = request.getSession();

		String usuario = request.getParameter("txtNombre");
		if (usuario != null || usuario.trim().length() == 0) {
			error.append("<p>Ingrese el usuario</p>");
			//request.setAttribute("error", usuario);
		}
		String password = request.getParameter("txtPassword");
		if (password != null || password.trim().length() == 0) {
			error.append("<p>Ingrese el passwor</p>");
			
		}
		if (usuario.equals("mauricio") && password.equals("123")) {
			httpSession.setAttribute("usuario", usuario);
			httpSession.setMaxInactiveInterval(10);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/admin.jsp");
			dispatcher.forward(request, response);
		} else {
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
			dispatcher.forward(request, response);
		}
	}

}
