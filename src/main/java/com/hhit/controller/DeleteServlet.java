package com.hhit.controller;




import com.hhit.dao.TestDAO;
import com.hhit.dao.factory.DaoFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//System.out.println("deleteServlet");
		request.setCharacterEncoding("UTF-8");
		int id = Integer.valueOf(request.getParameter("id"));
		int page = Integer.valueOf(request.getParameter("page"));
		String type =  request.getParameter("type");
		String key =  request.getParameter("key");
		TestDAO tdao = DaoFactory.gettestdao();
		int result = 0;
		if (type.equals("Choice")) {
			result = tdao.deletechoice(id);
		} else 
			result = tdao.deletefill(id);
		//response.sendRedirect("./TestManage?page=" + page + "&type=" + type + "&key=" + key);
		request.getRequestDispatcher("./TestManage?page=" + page + "&type=" + type + "&key=" + key).forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
