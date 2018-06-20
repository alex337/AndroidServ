package com.hhit.controller;



import com.hhit.dao.TestDAO;
import com.hhit.dao.factory.DaoFactory;
import com.hhit.model.choicequestion;
import com.hhit.model.fillquestion;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
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
		String type = request.getParameter("type");
		int page = Integer.valueOf(request.getParameter("page"));
		String key = request.getParameter("key");
		//key = new String(key.getBytes("ISO-8859-1"),"UTF-8");
		TestDAO tdao = DaoFactory.gettestdao();
		if (type.equals("Choice")) {
			choicequestion cq = new choicequestion();
			System.out.println(request.getParameter("testID"));
			cq.setC_id(Integer.valueOf(request.getParameter("testID")));
			cq.setC_question(request.getParameter("Title"));
			cq.setC_choiceA(request.getParameter("OptionA"));
			cq.setC_choiceB(request.getParameter("OptionB"));
			cq.setC_choiceC(request.getParameter("OptionC"));
			cq.setC_choiceD(request.getParameter("OptionD"));
			cq.setC_answer(request.getParameter("answer"));
			tdao.updatechoice(cq);
		} else {
			fillquestion fq = new fillquestion();
			fq.setF_id(Integer.valueOf(request.getParameter("testID")));
			fq.setF_question(request.getParameter("Title"));
			fq.setF_answer(request.getParameter("answer"));
			tdao.updatefill(fq);
		}
		request.setAttribute("type", type);
		request.setAttribute("key", key);
		request.setAttribute("page", page);
		response.setContentType("text/html; charset=UTF-8");
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
