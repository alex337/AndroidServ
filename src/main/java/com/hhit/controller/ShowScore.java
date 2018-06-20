package com.hhit.controller;



import com.hhit.dao.TestDAO;
import com.hhit.dao.factory.DaoFactory;
import com.hhit.model.stuscore;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Servlet implementation class ShowScore
 */
@WebServlet("/ShowScore")
public class ShowScore extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowScore() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("UTF-8");
		TestDAO tdao = DaoFactory.gettestdao();
		if (tdao.existscore() != 0) {
			List<stuscore> list = tdao.findscore();
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < list.size(); i++) {
				sb.append("<tr><td>");
				sb.append(list.get(i).getSid());
				sb.append("</td><td>");
				sb.append(list.get(i).getSname());
				sb.append("</td><td>");
				sb.append(list.get(i).getScore());
				sb.append("</td></tr>");
			}
			request.setAttribute("score", sb);
			//System.out.println(sb);
		} else {
			request.setAttribute("noScore", "noScore");
		}
		request.getRequestDispatcher("jsp/showScore.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
